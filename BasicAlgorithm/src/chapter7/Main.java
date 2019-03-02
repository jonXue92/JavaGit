package chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public static int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int ans = 1+Math.max(treeHeight(root.left),treeHeight(root.right));
        System.out.println(root.val + " height is : " + ans);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        System.out.println(BinaryTreePathSum.binaryTreePathSum(node1,5));
//        System.out.println(treeHeight(node1));
        ImportantinvertBinaryTree.invertBinaryTree(node1);
    }
}
