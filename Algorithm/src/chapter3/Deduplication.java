package chapter3;

import java.util.Arrays;
import java.util.HashSet;

public class Deduplication {
    public int deduplication(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (Integer item: set) {
            nums[result++] = item;
        }
        return result;
    }
    public int depulication2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }
}
