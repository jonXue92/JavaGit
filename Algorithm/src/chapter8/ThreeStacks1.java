package chapter8;

public class ThreeStacks1 {
    private int[] arr;
    private int[] index;
    private int size;
    public ThreeStacks1(int size) {
        this.size = size;
        arr = new int[size * 3];
        index = new int[3];
        for (int i = 0; i < 3; i++) {
            index[i] = i * size;
        }
    }
    public void push(int stackNum, int value) {
        arr[index[stackNum]++] = value;
    }
    public int pop(int stackNum) {
        int top = Integer.MIN_VALUE;
        if (!isEmpty(stackNum)) {
            top = arr[--index[stackNum]];
        }
        return top;
    }
    public int peek(int stackNum) {
        int top = Integer.MIN_VALUE;
        if (!isEmpty(stackNum)) {
            top = arr[index[stackNum] - 1];
        }
        return top;
    }
    public boolean isEmpty(int stackNum) {
        return index[stackNum] == stackNum * this.size;
    }
}
