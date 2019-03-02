package chapter5;

public class BinarySearchTree {

    BSTNode root = null;

    public boolean remove(int value) {
        if (root == null)
            return false;
        else {
            if (root.getValue() == value) {
                BSTNode auxRoot = new BSTNode(0);
                auxRoot.setLeftChild(root);
                boolean result = root.remove(value, auxRoot);
                root = auxRoot.getLeft();
                return result;
            } else {
                return root.remove(value, null);
            }
        }
    }
}

class BSTNode {
    private int value;
    private BSTNode left, right;

    BSTNode(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return this.value;
    }

    public BSTNode getLeft() {
        return this.left;
    }

    public BSTNode getRight() {
        return this.right;
    }

    public void setLeftChild(BSTNode left) {
        this.left = left;
    }

    public void setRightChild(BSTNode right) {
        this.right = right;
    }

    public boolean remove(int value, BSTNode parent) {
        if (value < this.value) {
            if (left != null)
                return left.remove(value, this);
            else
                return false;
        } else if (value > this.value) {
            if (right != null)
                return right.remove(value, this);
            else
                return false;
        } else {
            if (left != null && right != null) {
                this.value = right.minValue();
                right.remove(this.value, this);
            } else if (parent.left == this) {
                parent.left = (left != null) ? left : right;
            } else if (parent.right == this) {
                parent.right = (left != null) ? left : right;
            }
            return true;
        }
    }

    public int minValue() {
        if (left == null)
            return value;
        else
            return left.minValue();
    }
}