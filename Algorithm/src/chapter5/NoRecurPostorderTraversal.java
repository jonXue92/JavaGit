package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NoRecurPostorderTraversal {
    public List<Integer> noRecurPostorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> postorder = new ArrayList<>();
        TreeNode prev = null;
        TreeNode cur = root;

        if (root == null) {
            return postorder;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                postorder.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return postorder;
    }
}
