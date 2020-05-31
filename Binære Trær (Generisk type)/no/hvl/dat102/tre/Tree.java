package no.hvl.dat102.tre;

public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public TreeNode get(T value) {
        if (root != null)
            return root.get(value);

        return null;
    }

    // value is the index in the tree
    public void delete(T value) {
        root = delete(root, value);
    }

    private TreeNode<T> delete(TreeNode<T> subtreeRoot, T value) {
        if (subtreeRoot == null)
            return subtreeRoot;

        if (value.compareTo(subtreeRoot.getData()) < 0)
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));

        else if (value.compareTo(subtreeRoot.getData()) > 0)
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));

        else {
            // Cases 1 and 2: Node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null)
                return subtreeRoot.getRightChild();
            else if (subtreeRoot.getRightChild() == null)
                return subtreeRoot.getLeftChild();

            // Case 3: Node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public T min() {
        if (root == null)
            return null; // Kan resultere i nullPointer Exception
        else
            return root.min();
    }

    public T max() {
        if (root == null)
            return null; // Kan resultere i nullPointer Exception
        else
            return root.max();
    }

    public void traverseInOrder() {
        if (root != null)
            root.traverseInOrder();
    }
}
