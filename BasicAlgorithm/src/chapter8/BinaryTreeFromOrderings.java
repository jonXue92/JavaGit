package chapter8;

import chapter7.BinaryTreePathSum;

class TreeNode {
    public Object val;
    public TreeNode left,right;
    public TreeNode (Object val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTreeFromOrderings {
    public static void binaryTreeFromInPreOrderings(String inorder, String preorder) {
        if (inorder.length() == 0) {
            return;
        }
        TreeNode root = new TreeNode(preorder.charAt(0));
        int i = 0;
        while (inorder.charAt(i) != preorder.charAt(0)) {
            i++;
        }
        binaryTreeFromInPreOrderings(inorder.substring(0,i),preorder.substring(1,i+1));
        binaryTreeFromInPreOrderings(inorder.substring(i+1),preorder.substring(i+1));
        System.out.print(root.val);
    }
    public static void binaryTreeFromInPostOrderings(String inorder, String postorder) {
        int length = inorder.length();
        if (length == 0) {
            return;
        }
        TreeNode root = new TreeNode(postorder.charAt(length-1));
        int i = 0;
        while (inorder.charAt(i) != postorder.charAt(length-1)) {
            i++;
        }
        System.out.print(root.val);
        binaryTreeFromInPostOrderings(inorder.substring(0,i),postorder.substring(0,i));
        binaryTreeFromInPostOrderings(inorder.substring(i+1),postorder.substring(i,length-1));
    }
    public static int binaryTreeFromPrePostOrderings(String preorder, String postorder) {
        if (preorder.length() != postorder.length()) {
            return -1;
        }
        int length = preorder.length();
        if (length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length-1; i++) {
            for (int j = 1; j < length; j++) {
                if (preorder.charAt(i) == postorder.charAt(j) && preorder.charAt(i+1) == postorder.charAt(j-1)) {
                    count++;
                }
            }
        }
        return (int)Math.pow(2,count);
    }
    public static void main(String[] args) {
        String pre = "GDAFEMHZ";
        String in = "ADEFGHMZ";
        String post = "AEFDHZMG";
        String a = "abc";
        String b = "cba";
        System.out.println(in.substring(8));
        binaryTreeFromInPreOrderings(in,pre);
        System.out.println();
        binaryTreeFromInPostOrderings(in,post);
        System.out.println();
        System.out.println(binaryTreeFromPrePostOrderings(pre,post));
        System.out.println(binaryTreeFromPrePostOrderings(a,b));
    }
}
