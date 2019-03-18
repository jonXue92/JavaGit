package binaryIndexedTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        discretization(nums);

        // build bit array
        int[] bit = new int[nums.length + 1];
        int[] count = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = getSum(bit, nums[i] - 1);
            update(bit, nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }
    // this is nlogn
    // sort the original array and mapping the number to the order in the sorted array;
    private void discretization(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }
    }
    private void update(int[] bit, int index) {
        for (int i = index; i < bit.length; i += lowbit(i)) {
            bit[i]++;
        }
    }
    private int getSum(int[] bit, int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= lowbit(i)) {
            sum += bit[i];
        }
        return sum;
    }
    private int lowbit(int x) {
        return x & -x;
    }
}
