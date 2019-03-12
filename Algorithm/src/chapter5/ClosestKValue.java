package chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestKValue {
    // 最优算法，时间复杂度 O(k + logn)，空间复杂度 O(logn)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (k == 0 || root == null) {
            return res;
        }
        Stack<TreeNode> lowerStack = getStack(root, target);
        Stack<TreeNode> upperStack = new Stack<>();
        upperStack.addAll(lowerStack);
        if (target < lowerStack.peek().val) {
            moveLower(lowerStack);
        } else {
            moveUpper(upperStack);
        }
        for (int i = 0; i < k; i++) {
            if (lowerStack.isEmpty() || target - lowerStack.peek().val > upperStack.peek().val - target) {
                res.add(upperStack.peek().val);
                moveUpper(upperStack);
            } else {
                res.add(lowerStack.peek().val);
                moveLower(lowerStack);
            }
        }
        return res;
    }
    // 在假装插入target的时候，看看一路走过的节点都是哪些，放到stack里，用于iterate
    private Stack<TreeNode> getStack(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return stack;
    }
    // 根据stack，挪动到next node
    public void moveUpper(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.right == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().right == node) {
                node = stack.pop();
            }
            return;
        }
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    // 根据stack，挪动到prev node
    public void moveLower(Stack<TreeNode> stack) {
        TreeNode node = stack.peek();
        if (node.left == null) {
            node = stack.pop();
            while (!stack.isEmpty() && stack.peek().left == node) {
                node = stack.pop();
            }
            return;
        }
        node = node.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
    }
}
