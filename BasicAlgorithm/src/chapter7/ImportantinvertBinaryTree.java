package chapter7;

import java.util.Stack;

public class ImportantinvertBinaryTree {
    public static void invertBinaryTree(TreeNode root) {
        /*非递归*/
        //利用inorder traverse, stack pop出一个node后，把这个node的左右调换，然后接下来进入的是root.left而非往常的root.right
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;

            cur = cur.left;
        }
    }
}
