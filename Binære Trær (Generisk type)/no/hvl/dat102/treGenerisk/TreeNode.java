package no.hvl.dat102.treGenerisk;

public class TreeNode<T extends Comparable<T>> {

    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode (T data) {
        this.data = data;
    }

    public void insert(T value) {
        if (value == data)
            return;

        if (value.compareTo(data) < 0) {
            if (leftChild == null) {
                leftChild = new TreeNode<>(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else {
            if (rightChild == null) {
                rightChild = new TreeNode<>(value);
            }
            else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode<T> get(T value) {
        if (value.compareTo(data) == 0) {
            return this;
        }

        if (value.compareTo(data) < 0) {
            if (leftChild != null)
                return leftChild.get(value);
        }
        else {
            if (rightChild != null)
                return rightChild.get(value);
        }
        return null;
    }

    // brukes for å slette et element. Alternativet er å returnere TreeNode, men da må slettemetoden bruke TreeNode.get()
    public T min() {
        if (leftChild == null)
            return data;
        else
            return leftChild.min();
    }

    public T max() {
        if (rightChild == null)
            return data;
        else
            return rightChild.max();
    }

    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public TreeNode<T> getLeftChild() { return leftChild; }
    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }
    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
