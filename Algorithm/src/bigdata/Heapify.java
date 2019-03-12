package bigdata;

public class Heapify {
    public void insert(int value, int[] heap) {
        int childIndex, parentIndex;
        heap[0] += 1;
        heap[heap[0]] = value;
        // recover heap property
        percolateUp(heap);
    }
    public void percolateUp(int[] heap) {
        int lightIndex, parentIndex;
        lightIndex = heap[0];
        parentIndex = lightIndex / 2;
        // lightIndex is root ? && swap ?
        while ((parentIndex > 0) && (heap[lightIndex] < heap[parentIndex])) {
            int temp = heap[lightIndex];
            heap[lightIndex] = heap[parentIndex];
            heap[parentIndex] = temp;
            lightIndex = parentIndex;
            parentIndex = lightIndex / 2;
        }
    }
    public int deleteMin(int[] heap) {
        int min;
        if (heap[0] < 1) {
            System.out.println("Error: delete min from an empty heap.");
            return Integer.MIN_VALUE;
        }
        min = heap[1];
        int temp = heap[heap[0]];
        heap[heap[0]] = heap[1];
        heap[1] = temp;
        heap[0] -= 1;
        percolateDown(heap);
        return min;
    }
    public void percolateDown(int[] heap) {
        int heavyIndex;
        int childIndex1, childIndex2, minIndex;
        int sign; // state variable, 1: swap; 0: no swap
        heavyIndex = 1;
        do {
            sign = 0;
            childIndex1 = heavyIndex * 2;
            childIndex2 = childIndex1 + 1;
            if (childIndex1 > heap[0]) {
                // both children are null
                break;
            } else if (childIndex2 > heap[0]) {
                // right children is null
                minIndex = childIndex1;
            } else {
                minIndex = (heap[childIndex1] < heap[childIndex2]) ? childIndex1 : childIndex2;
            }
            if (heap[heavyIndex] > heap[minIndex]) {
                int temp = heap[heavyIndex];
                heap[heavyIndex] = heap[minIndex];
                heap[minIndex] = temp;
                heavyIndex = minIndex;
                sign = 1;
            }
        } while (sign == 1);
    }
}
