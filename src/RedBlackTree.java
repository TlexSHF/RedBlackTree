public class RedBlackTree<K extends Comparable<K>, V> implements IRedBlackTree<K, V>{

    public class TreeNode {
        K key;
        V value;
        boolean isRed;

        TreeNode left;
        TreeNode right;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.isRed = true;
        }
    }

    TreeNode root = null;

    @Override
    public void put(K key, V value) {
        root = put(key, value, root);
        root.isRed = false;
    }
    private TreeNode put(K key, V value, TreeNode subTreeRoot) {
        if(subTreeRoot == null) {
            return new TreeNode(key, value);
        }

        int cmp = key.compareTo(subTreeRoot.key);

        if(cmp < 0) {
            subTreeRoot.left = put(key, value, subTreeRoot.left);

        } else if(cmp > 0) {
            subTreeRoot.left = put(key, value, subTreeRoot.left);

        } else {
            subTreeRoot.value = value;
        }

        //Is there a red on only right side
        if(!isRed(subTreeRoot.left) && isRed(subTreeRoot.right)) {
            subTreeRoot = leftRotation(subTreeRoot);
        }
        //Is there consecutive left reds
        if(isRed(subTreeRoot.left) && isRed(subTreeRoot.left.left)) {
            subTreeRoot = rightRotation(subTreeRoot);
        }
        //Is both children red
        if(isRed(subTreeRoot.left) && isRed(subTreeRoot.right)) {
            colorFlip(subTreeRoot);
        }
        //By NOT checking for NULL here, generating serious errors

        return subTreeRoot;
    }

    private TreeNode leftRotation(TreeNode subTreeRoot) {

        TreeNode x = subTreeRoot.right;
        subTreeRoot.right = x.left;
        x.left = subTreeRoot;

        x.isRed = subTreeRoot.isRed;
        subTreeRoot.isRed = true;

        return x;
    }
    private TreeNode rightRotation(TreeNode subTreeRoot) {

        TreeNode x = subTreeRoot.left;
        subTreeRoot.left = x.right;
        x.right = subTreeRoot;

        x.isRed = subTreeRoot.isRed;
        subTreeRoot.isRed = true;

        return x;
    }
    private void colorFlip(TreeNode subTreeRoot) {

        subTreeRoot.isRed = !subTreeRoot.isRed;

        if(subTreeRoot.left != null) {
            subTreeRoot.left.isRed = !subTreeRoot.left.isRed;
        }
        if(subTreeRoot.right != null) {
            subTreeRoot.right.isRed = !subTreeRoot.right.isRed;
        }
    }
    private boolean isRed(TreeNode node) {
        if(node == null) {
            return false;
        }
        return node.isRed;
    }

    @Override
    public V get(K key) {

        return get(key, root);
    }
    private V get(K key, TreeNode subTreeRoot) {
        if(subTreeRoot == null) {
            return null;
        }

        int cmp = key.compareTo(subTreeRoot.key);

        if(cmp == 0) {
            return subTreeRoot.value;

        } else if(cmp < 0) {
            return get(key, subTreeRoot.left);

        } else {
            return get(key, subTreeRoot.right);

        }
    }

    @Override
    public void delete() {

    }

    public void printTree() {

        System.out.println("hello!");
        System.out.println(printTree("", root));
    }
    private String printTree(String output, TreeNode subTreeRoot) {

        if(root.left == null && root.right == null) {
            return "[" + subTreeRoot.value + ']';
        }

        if(root.left != null) {
            output += printTree(output, root.left);
        }
        if(root.right != null) {
            output += printTree(output, root.right);
        }

        return output;
    }
}