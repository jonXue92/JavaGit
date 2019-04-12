package chapter5;

import java.util.ArrayList;
import java.util.List;

// Divide Conquer
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path: leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path: rightPaths) {
            paths.add(root.val + "->" + path);
        }
        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        return paths;
    }
    // Traverse
    public List<String> binaryTreePaths0(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, String.valueOf(root.val), result);
        return result;
    }
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + String.valueOf(root.left.val), result);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }
}
