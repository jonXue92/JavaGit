package chapter5;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
}
