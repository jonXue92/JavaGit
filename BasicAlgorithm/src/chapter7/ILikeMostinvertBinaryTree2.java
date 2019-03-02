package chapter7;

import java.util.Stack;

public class ILikeMostinvertBinaryTree2 {
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();

            TreeNode t = node.left;
            node.left = node.right;
            node.right = t;

            if(node.left != null)
            {
                stack.push(node.left);
            }
            if(node.right != null)
            {
                stack.push(node.right);
            }
        }
    }
}
