package chapter6;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public MyQueue() {
        // do intialization if necessary
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */

    public void push(int element) {
        // write your code here
        s1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
}
