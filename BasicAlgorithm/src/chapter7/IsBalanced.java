package chapter7;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        return isHeightBalanced(root) != -1;
    }

    private int isHeightBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isHeightBalanced(root.left);
        int right = isHeightBalanced(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
