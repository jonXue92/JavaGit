package chapter8;

import java.awt.datatransfer.Transferable;

public class ThreeStacks2 {
    private class Pair {
        private int stack;
        private int num;
        public Pair(int stack, int num) {
            this.stack = stack;
            this.num = num;
        }
    }
    private Pair[] array;
    private int[] pointers;
    private int[] sizes;
    public ThreeStacks2(int size) {
        array = new Pair[size * 3];
        pointers = new int[3];
        sizes = new int[3];
        for (int i = 0; i < 3; i++) {
            pointers[i] = -1;
        }
    }
    public void push(int stackNum, int value) {
        int p = pointers[stackNum];
        p++;
        while (p < array.length && array[p] != null) {
            p++;
        }
        array[p] = new Pair(stackNum, value);
        sizes[stackNum]++;
        pointers[stackNum] = p;
    }
    public int pop(int stackNum) {
        Pair res = null;
        int p = pointers[stackNum];
        if (!isEmpty(stackNum)) {
            res = array[p];
            array[p--] = null;
            sizes[stackNum]--;
            while (p >= 0 && (array[p] == null || array[p].stack != stackNum)) {
                p--;
            }
        }
        pointers[stackNum] = p;
        if (res != null) {
            return res.num;
        }
        return -1;
    }
    public int peek(int stackNum) {
        int p = pointers[stackNum];
        if (p != -1) {
            return array[p].num;
        }
        return -1;
    }
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
}
