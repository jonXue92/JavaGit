package chapter8;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueueStack {
    public Queue<Integer> queue1 = new LinkedList<>();
    public Queue<Integer> queue2 = new LinkedList<>();
    public void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    public void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public void push(int x) {
        queue1.offer(x);
    }
    public void pop() {
        moveItems();
        queue1.poll();
        swapQueues();
    }
    public int top() {
        moveItems();
        int item = queue1.poll();
        swapQueues();
        queue1.offer(item);
        return item;
    }
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
