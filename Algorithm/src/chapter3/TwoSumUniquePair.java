package chapter3;

import java.util.Arrays;

public class TwoSumUniquePair {
    public int twoSumUniquePair(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0, left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                count++;
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
