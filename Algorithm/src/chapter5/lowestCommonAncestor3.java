package chapter5;

class ResultType_LCA {
    public boolean has_A, has_B;
    public TreeNode node;
    ResultType_LCA(boolean a, boolean b, TreeNode n) {
        has_A = a;
        has_B = b;
        node = n;
    }
}
public class lowestCommonAncestor3 {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType_LCA rt = helper(root, A, B);
        if (rt.has_A && rt.has_B) {
            return rt.node;
        }
        return null;
    }
    private ResultType_LCA helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType_LCA(false, false, null);
        }
        ResultType_LCA left_rt = helper(root.left, A, B);
        ResultType_LCA right_rt = helper(root.right, A, B);
        boolean has_A = left_rt.has_A || right_rt.has_A || root == A;
        boolean has_B = left_rt.has_B || right_rt.has_B || root == B;
        if (root == A || root == B) {
            return new ResultType_LCA(has_A, has_B, root);
        }
        if (left_rt.node != null && right_rt.node != null) {
            return new ResultType_LCA(has_A, has_B, root);
        }
        if (left_rt.node != null) {
            return new ResultType_LCA(has_A, has_B, left_rt.node);
        }
        if (right_rt.node != null) {
            return new ResultType_LCA(has_A, has_B, right_rt.node);
        }
        return new ResultType_LCA(has_A, has_B, null);
    }
}
