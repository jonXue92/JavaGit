package chapter5;

public class MergeSort {
    public void mergeSort(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] temp = new int[A.length];
        mergeSortHelper(A, 0, A.length - 1, temp);
    }
    private void mergeSortHelper(int[] nums, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSortHelper(nums, start, mid, temp);
        mergeSortHelper(nums, mid + 1, end, temp);
        merge(nums, start, end, temp);
    }
    private void merge(int[] nums, int start, int end, int[] temp) {
        int mid = start + (end - start) / 2;
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                temp[index++] = nums[leftIndex++];
            } else {
                temp[index++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= mid) {
            temp[index++] = nums[rightIndex++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
