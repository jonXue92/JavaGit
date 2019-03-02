package chapter8;

import java.util.Queue;

public class LinkedListQueue {
    private QueueNode dummy, tail;

    public LinkedListQueue() {
        dummy = new QueueNode(-1);
        tail = dummy;
    }

    public void enqueue(int val) {
        QueueNode node = new QueueNode(val);
        tail.next = node;
        tail = node;
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int ele = dummy.next.val;
        dummy.next = dummy.next.next;
        if (dummy.next == null) {
            tail = dummy;
        }
        return ele;
    }

    public int peek() {
        return dummy.next.val;
    }

    public boolean isEmpty() {
        return dummy.next == null;
    }
}

class QueueNode {
    public int val;
    public QueueNode next;
    public QueueNode(int value) {
        this.val = value;
    }
}
