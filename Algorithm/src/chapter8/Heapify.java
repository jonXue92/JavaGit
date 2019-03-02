package chapter8;

import java.util.PriorityQueue;
import java.util.Queue;

public class Heapify {
    private void siftup(int[] A, int k) {
        while (k != 0) {
            int father = (k - 1) / 2;
            if (A[k] > A[father]) {
                break;
            }
            int temp = A[k];
            A[k] = A[father];
            A[father] = temp;

            k = father;
        }
    }
    public void upHeapify(int[] A) {
        for (int i = 0; i < A.length; i++) {
            siftup(A, i);
        }
    }
    private void siftdown(int[] A, int k) {
        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2]) {
                son = k * 2 + 2;
            }
            if (A[son] >= A[k]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }
    public void downHeapify(int[] A) {
        for (int i = (A.length - 1) /2; i >= 0; i--) {
            siftdown(A, i);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> heap = new PriorityQueue<>();
    }
}
