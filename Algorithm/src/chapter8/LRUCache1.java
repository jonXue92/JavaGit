package chapter8;

import java.util.HashMap;

public class LRUCache1 {
    private class Node {
        Node prev, next;
        int key, value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    // HEAD和TAIL这两个都是DUMMY NODE
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // remove current
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        // move current to tail
        moveToTail(current);
        return map.get(key).value;
    }
    public void set(int key, int value) {
        // get 这个方法会把key挪到最末端，不需要再调用 move_to_tail
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }
    private void moveToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}
