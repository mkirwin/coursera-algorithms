public class QuickFindUF {

    private int[] id;
    private int[] sz;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /** Simply changes the connectivity group to that of the 'second'
     * For a more efficient algorithm, make "roots"
     */
    public void union(int p, int q) {
        int firstGroup = id[p];
        int secondGroup = id[q];

        if (firstGroup != secondGroup) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == firstGroup) {
                    id[i] = secondGroup;
                }
            }
        }
    }

    /** Makes a hierarchical tree structure instead.
     * quickUnion is slow in a different way: you could have a worst-case
     * tree that is basically a linked list, making the connected method 
     * terrible.
     */
    public void quickUnion(int p, int q) {
        int i = id[p];
        int j = id[q];
        id[i] = j;
    }

    /** Despite its name, it is not quick.
     * This is due to the shitty-ish nature of quickUnion.
     */
    public boolean quickConnected(int p, int q) {
        return root(p) == root(q);
    }

    /**Finds the root of an item (at index i).
     */
    private int root(int i) {
        while (i != id[i]) { 
            id[i] = id[id[i]]; // flatten the tree! 'Quck-Union Improvements'
            i = id[i]; 
        }
        return i;
    }

    /**How can we deal with these inefficiencies?
     * We can try to 'balance' our trees a bit, or at least make sure we don't
     * get ridiculous looking trees.
     *
     * We can add a second array to keep track of which 'trees' are bigger.
     */

    public void quickerUnion(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
