package chapter5;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SortedListToBST {
    private ListNode current;

    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size = getListLength(head);
        current = head;
        return helper(size);
    }
    private TreeNode helper(int size) {
        if (size <= 0) {
            return null;
        }
        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(size - 1 - size / 2);
        root.left = left;
        root.right = right;
        return root;
    }
}
