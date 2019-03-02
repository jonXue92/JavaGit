package chapter3;

import java.util.Arrays;

public class HeapSort {
    public static void adjustHeap(int arr[], int s, int e) {
        int temp = arr[s];
        for (int i = s * 2; i <= e; i++) {
            if (i < e && arr[i] < arr[i + 1]) {
                i++;//右边的大
            }
            if (arr[i] <= temp) {//已经满足最大根堆的条件
                break;
            }
            arr[s] = arr[i];
            s = i;
        }
        arr[s] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {0, 8, 2, 3, 9, 5, 6};
        int length = arr.length - 1;
        //调整为大根堆
        for (int i = length/2; i > 0; i--) {
            adjustHeap(arr, i, length);
        }
        System.out.println(Arrays.toString(arr));
        //和第一个元素交换，然后再调整为大根堆
        for (int i = length; i > 1; i--) {
            swap(arr, 1, i);
            adjustHeap(arr, 1, i-1);
        }
        System.out.println(Arrays.toString(arr));
    }
}
