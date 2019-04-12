package chapter5;

public class FindSubtree2 {
    private class ResultType {
        public int sum, size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    private TreeNode subtree = null;
    private ResultType subtreeResult = null;
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        // 分治法计算左右子树的平均值
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // 当前subtree的结果是左右两棵子树的和的平均值加上自身
        ResultType result = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);
        if (subtree == null || subtreeResult.sum * 1.0 / subtreeResult.size < result.sum * 1.0 / result.size) {
            subtree = root;
            subtreeResult = result;
        }
        return result;
    }
}
