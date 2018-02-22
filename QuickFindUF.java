public class QuickFindUF {

    private int[] id;

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
    public quickConnected(int p, int q) {
        return root(p) == root(q);
    }

    /**Finds the root of an item (at index i).
     */
    private root(int i) {
        while (i != id[i]) { i = id[i]; }
        return i;
    }

}
