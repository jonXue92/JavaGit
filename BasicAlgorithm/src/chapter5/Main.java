package chapter5;

import java.util.*;

public class Main {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        ListNode cur=n1;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        reverse(n1);
        cur=n4;
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
