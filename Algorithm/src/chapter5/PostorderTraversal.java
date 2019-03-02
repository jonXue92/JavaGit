package chapter5;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result =new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // previously traversed node
        TreeNode cur = root;
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) { // traverse down the tree
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == prev) { // traverse up the tree from the left
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else { // traverse up the tree from the right
                result.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return  result;
    }

    private void postorderTraverse0(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraverse0(root.left, result);
        postorderTraverse0(root.right, result);
        result.add(root.val);  // 注意访问根节点放到了最后
    }
}
