package chapter6;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1=new LinkedList<Integer>();
    Queue<Integer> queue2=new LinkedList<Integer>();
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int item = queue1.peek();
        queue2.offer(queue1.poll());
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        return item;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.isEmpty();
    }
}
