package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class PreorderTraversal {
    public List<Integer> preorderTravse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }
    private void preorderTraverse0(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraverse0(root.left, result);
        preorderTraverse0(root.right, result);
    }
    public List<Integer> preorderTravser1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> left = preorderTravser1(root.left);
        List<Integer> right = preorderTravser1(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}
