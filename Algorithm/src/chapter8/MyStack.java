package chapter8;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    List<Integer> array = new ArrayList<>();
    public void push(int x) {
        array.add(x);
    }
    public void pop() {
        if (isEmpty()) {
            array.remove(array.size() - 1);
        }
    }
    public int top() {
        return array.get(array.size() - 1);
    }
    public boolean isEmpty() {
        return array.size() == 0;
    }
}
