package chapter5;

public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }
        TreeNode leftLCA = lowestCommonAncestor(root.left, A, B);
        TreeNode rightLCA = lowestCommonAncestor(root.right, A, B);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        if (leftLCA != null) {
            return leftLCA;
        }
        if (rightLCA != null) {
            return rightLCA;
        }
        return null;
    }
}
