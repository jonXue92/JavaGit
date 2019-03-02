package chapter7;

public class ILikeMostisBalanced {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) return true;
        traverse(root);
        return flag;
    }
    public int traverse(TreeNode node){
        if(node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
