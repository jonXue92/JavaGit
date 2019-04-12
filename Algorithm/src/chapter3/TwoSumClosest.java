package chapter3;

import java.util.Arrays;

public class TwoSumClosest {
    public int twoSumCloset(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                diff = Math.min(diff, nums[left] + nums[right] - target);
                right--;
            } else {
                diff = Math.min(diff, target - nums[left] - nums[right]);
                left++;
            }
        }
        return diff;
    }
}
