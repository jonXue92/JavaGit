package chapter8;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class ListNode {
        public int key, val;
        public ListNode next;
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    private int capacity, size;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> keyToPrev;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<Integer, ListNode>();
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
    }
    private void moveToTail(int key){
        ListNode prev = keyToPrev.get(key);
        ListNode cur = prev.next;
        if (tail == cur) {
            return;
        }
        prev.next = prev.next.next;
        cur.next = null;
        tail.next = cur;
        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }
        keyToPrev.put(cur.key, tail);
        tail = cur;
    }
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }
    public void set(int key, int value) {
        // get method will move the key to the end of the linked list
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }
        if (size < capacity) {
            size++;
            ListNode cur = new ListNode(key, value);
            tail.next = cur;
            keyToPrev.put(key, tail);
            tail = cur;
            return;
        }
        // replace the first node with new key, value
        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        moveToTail(key);
    }
}
