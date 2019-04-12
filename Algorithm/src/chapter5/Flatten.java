package chapter5;

import java.util.Stack;

public class Flatten {
    // Traverse
    private TreeNode lastNodeTraverse = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (lastNodeTraverse != null) {
            lastNodeTraverse.left = null;
            lastNodeTraverse.right = root;
        }
        lastNodeTraverse = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    // Divide & Conquer
    public void flatten1(TreeNode root) {
        helper(root);
    }
    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }
    // Non-Recursion
    public void flatten0(TreeNode root) {
        if (root ==  null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            // connect
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}
