package chapter8;

// 三个栈交叉，需要用链表的形式连接起来。解法显然适合follow up：假设三个栈不一样大的话？
public class ThreeStacks {
    public int stackSize;
    public int indexUsed;
    public int[] stackPointer;
    public StackNode[] buffer;

    public ThreeStacks(int size) {
        this.stackSize = size;
        stackPointer = new int[3];
        for (int i = 0; i < 3; i++) {
            stackPointer[i] = -1;
        }
        indexUsed = 0;
        buffer = new StackNode[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        int lastIndex = stackPointer[stackNum];
        stackPointer[stackNum] = indexUsed;
        indexUsed++;
        buffer[stackPointer[stackNum]] = new StackNode(lastIndex, value, -1);
        if (lastIndex != -1) {
            buffer[lastIndex].next = stackPointer[stackNum];
        }
    }
    public int pop(int stackNum) {
        int value = buffer[stackPointer[stackNum]].value;
        int lastIndex = stackPointer[stackNum];
        if (lastIndex != indexUsed - 1) {
            swap(lastIndex, indexUsed - 1, stackNum);
        }
        stackPointer[stackNum] = buffer[stackPointer[stackNum]].prev;
        if (stackPointer[stackNum] != -1) {
            buffer[stackPointer[stackNum]].next = -1;
        }
        buffer[indexUsed - 1] = null;
        indexUsed--;
        return value;
    }
    public int peek(int stackNum) {
        return buffer[stackPointer[stackNum]].value;
    }
    public boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }
    public void swap(int lastIndex, int topIndex, int stackNum) {
        if (buffer[lastIndex].prev == topIndex) {
            int tmp = buffer[lastIndex].value;
            buffer[lastIndex].next = buffer[topIndex].value;
            buffer[topIndex].value = tmp;
            int tp = buffer[topIndex].prev;
            if (tp != -1) {
                buffer[tp].next = lastIndex;
            }
            buffer[lastIndex].prev = tp;
            buffer[lastIndex].next = topIndex;
            buffer[topIndex].prev = lastIndex;
            buffer[topIndex].next = -1;
            stackPointer[stackNum] = topIndex;
            return;
        }
        int lp = buffer[lastIndex].prev;
        if (lp != -1) {
            buffer[lp].next = topIndex;
        }
        int tp = buffer[topIndex].prev;
        if (tp != -1) {
            buffer[tp].next = lastIndex;
        }
        int tn = buffer[topIndex].next;
        if (tn != -1) {
            buffer[tn].prev = lastIndex;
        } else {
            for (int i = 0; i < 3; i++) {
                if (stackPointer[i] == topIndex) {
                    stackPointer[i] = lastIndex;
                }
            }
        }
        StackNode tmp = buffer[lastIndex];
        buffer[lastIndex] = buffer[topIndex];
        buffer[topIndex] = tmp;
        stackPointer[stackNum] = topIndex;
    }
}

class StackNode {
    public int prev, next;
    public int value;
    public StackNode(int p, int v, int n) {
        this.value = v;
        this.prev = p;
        this.next = n;
    }
}
