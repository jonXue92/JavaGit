package chapter3;

import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class TwoSumBST {
    TreeNode root;
    public int[] twoSumBST(TreeNode root, int n) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }
        this.root = root;
        return inorder(root, n);
    }
    public int[] inorder(TreeNode root, int n) {
        if (root == null) {
            return null;
        }
        int[] res = null;
        int[] left = inorder(root.left, n);
        if (find(this.root, n - root.val, root)) {
            res = new int[2];
            res[0] = root.val;
            res[1] = n - root.val;
            return res;
        }
        int[] right = inorder(root.right, n);
        return left != null ? left : right;
    }
    public boolean find(TreeNode root, int target, TreeNode pre) {
        if (root == null) {
            return false;
        }
        if (root.val == target && root != pre) {
            return true;
        }
        if (root.val < target) {
            return find(root.right, target, pre);
        } else {
            return find(root.left, target, pre);
        }
    }
    public int[] twoSumBST2(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        return helper(set, root, n);
    }
    private int[] helper(HashSet<Integer> set, TreeNode root, int n) {
        if (root == null) {
            return null;
        }
        if (!set.contains(n - root.val)) {
            set.add(root.val);
            int[] left = helper(set, root.left, n);
            int[] right = helper(set, root.right, n);
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
            return null;
        } else {
            int[] res = new int[2];
            res[0] = n - root.val;
            res[1] = root.val;
            return res;
        }
    }
}
