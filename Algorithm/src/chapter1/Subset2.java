package chapter1;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    private void dfs(int[] nums, int startIndex, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> results) {
        // deep copy & add to results
        results.add(new ArrayList<Integer>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            // startIndex - 1, >= startIndex + 1
            if (i != 0 && nums[i - 1] == nums[i] && i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}
