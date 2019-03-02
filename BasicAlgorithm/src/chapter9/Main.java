package chapter9;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {    public static ListNode insertionSortList(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
        return head;
    }
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
        ListNode tmp = dummy;
        while (tmp.val < cur.val && tmp.next.val < cur.val) {
            tmp = tmp.next;
        }
        if (tmp != pre) {
            swap(tmp,pre);
            cur = pre.next;
        }
        else {
            pre = pre.next;
            cur = cur.next;
        }
    }
    return dummy.next;
}
    private static void swap(ListNode node1, ListNode node2) {
        ListNode tmp1 = node2.next;
        node2.next = node2.next.next;
        ListNode tmp2 = node1.next;
        node1.next = tmp1;
        tmp1.next = tmp2;
    }
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode res = insertionSortList(node1);
        while (res != null) {
            System.out.print(res.val+"->");
            res = res.next;
        }
        System.out.print("null");
    }
}