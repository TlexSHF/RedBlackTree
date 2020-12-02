public interface IRedBlackTree<K, V> {

    /* RBT RULES:
     * - Root must be black
     * - Red nodes van only exist on left side
     * - No two consecutive red nodes can exist
     * - No node can have both children red
     */

    void put(K key, V value);
    V get(K key);
    void delete();

    /* PRIVATE FUNCTIONS:

    TreeNode put(int key, String value, TreeNode subTreeRoot);
    TreeNode colorFlip(TreeNode subTreeRoot);
    TreeNode rightRotation(TreeNode subTreeRoot);
    TreeNode leftRotation(TreeNode subTreeRoot);

     class TreeNode {}

    */
}