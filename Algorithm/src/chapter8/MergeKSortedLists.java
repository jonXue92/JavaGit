package chapter8;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = next;
    }
}

public class MergeKSortedLists {
    public ListNode mergeKLists0(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };
    public ListNode mergeKLists1(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.offer(head.next);
            }
        }
        return dummy.next;
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        while (lists.size() > 1) {
            List<ListNode> newLists = new ArrayList<>();
            for (int i = 0; i < lists.size() - 1; i += 2) {
                ListNode mergedList = mergeTwoLists(lists.get(i), lists.get(i + 1));
                newLists.add(mergedList);
            }
            if (lists.size() % 2 == 1) {
                newLists.add(lists.get(lists.size() - 1));
            }
            lists = newLists;
        }
        return lists.get(0);
    }
}
