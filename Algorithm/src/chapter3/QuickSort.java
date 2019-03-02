package chapter3;

public class QuickSort {
//    只要求返回一個pivot_index， 下面遞歸用
//    quickSort(A, start, pivot_index-1);
//    quickSort(A, pivot_index+1, end);
    public void sortIntegers(int[] A) {
        quick_sort(A, 0, A.length-1);
    }

    private void quick_sort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot_index = partition(A, start, end);
        quick_sort(A, start, pivot_index-1);
        quick_sort(A, pivot_index+1, end);
    }

    private int partition(int A[], int start, int end) {
        int pivot_index = start+(end-start)/2;
        int pivot = A[pivot_index];
        // swap A[start] and A[pivot_index]
        int t = A[start];
        A[start] = A[pivot_index];
        A[pivot_index] = t;
        // partition A[start+1...end] so that A[start+1...r] <= pivot and A[l...end] >= pivot
        int l = start+1, r = end;
        while (l <= r) {
            while (l <= r && A[l] < pivot) {
                l++;
            }
            while (l <= r && A[r] > pivot) {
                r--;
            }
            if (l <= r) {
                t = A[l];
                A[l] = A[r];
                A[r] = t;
                l++;
                r--;
            }
        }
        // swap pivot and A[r]
        A[start] = A[r];
        A[r] = pivot;
        return r;
    }
}
