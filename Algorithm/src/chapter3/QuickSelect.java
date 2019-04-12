package chapter3;

public class QuickSelect {
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (k - 1 >= i) {
            return quickSelect(nums, i, end, k);
        }
        return nums[k - 1];
    }
}
