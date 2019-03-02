package chapter8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class CircularQueue {
    int[] circularArray;
    int front;
    int rear;
    int size;
    public CircularQueue(int n) {
        this.circularArray = new int[n];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isFull() {
        return size == circularArray.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new RuntimeException("Queue is already full!");
        }
        rear = (front + size) % circularArray.length;
        circularArray[rear] = element;
        size += 1;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is already empty!");
        }
        int ele = circularArray[front];
        front = (front + 1) % circularArray.length;
        size -= 1;
        return ele;
    }
}
