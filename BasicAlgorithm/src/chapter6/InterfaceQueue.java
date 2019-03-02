package chapter6;

//class Node {
//    public int val;
//    public Node next, prev;
//    public Node(int _val) {
//        val = _val;
//        prev = next = null;
//    }
//}

interface InterFaceQueue {
    void push(int element);

    // define an interface for pop method
    /* write your code here */
    int pop();

    // define an interface for top method
    /* write your code here */
    int top();
}

public class InterfaceQueue implements InterFaceQueue {
    /* you can declare your private attributes here */
    public Node first, last;

    public InterfaceQueue() {
        // do initialization if necessary
    }

    // implement the push method
    /* write your code here */
    @Override
    public void push(int val) {
        if (last == null) {
            last = new Node(val);
            first = last;
        } else {
            Node node = new Node(val);
            last.next = node;
            node.prev = last;
            last = last.next;
        }
    }

    @Override
    public int pop() {
        /* write your code here */
        if (first != null) {
            int val = first.val;
            first = first.next;
            if (first != null)
                first.prev = null;
            else
                last = null;
            return val;
        }
        return -1;
    }

    @Override
    public int top() {
        /* write your code here */
        if (first != null) {
            return first.val;
        }
        return -1;
    }
}
