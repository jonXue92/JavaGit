package chapter5;

public class QuickSort {
    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSortHelper(nums, 0, nums.length - 1);
    }
    private void quickSortHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quickSortHelper(nums, start, right);
        quickSortHelper(nums, left, end);
    }
}
