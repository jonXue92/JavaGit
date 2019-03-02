package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InterfaceTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.addFirst(10);
        System.out.println(getListSum(arrayList));
        System.out.println(getListSum(linkedList));
        System.out.println(IntStack.val);
//        IntStack.val = 10;

        List<Integer> arrayList2 = new ArrayList<>();
        List<Integer> linkedList2  = new LinkedList<>();
//        ((LinkedList<Integer>) linkedList2).addFirst();

        IntStack intstack = new IntStackArrayListImpl();
//        ((IntStackArrayListImpl) intstack).print();
        IntStack2 intstack2 = new IntStackLinkedListImpl();
    }
    public static int getListSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
interface IntStack {
    void push(int val);
    int pop();
    int peek();
    boolean isEmpty();
    void clear();

    int val = 10;
}

abstract class IntStack2 {
    abstract void push(int val);
    abstract int pop();
    abstract int peek();
    abstract boolean isEmpty();
    abstract void clear();

    int val = 10;
}

class IntStackArrayListImpl implements IntStack {

    private ArrayList<Integer> data;

    public IntStackArrayListImpl() {
        data = new ArrayList<>();
//        val = 20;
    }

    @Override
    public void push(int val) {
        data.add(val);
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
    public void print() {}
}

class IntStackLinkedListImpl extends IntStack2 {

//    private ListNode head;
//    private ListNode tail;

    public IntStackLinkedListImpl() {
    }

    @Override
    public void push(int val) {

    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }
}