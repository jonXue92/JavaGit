package chapter67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        return results;
    }
    private void dfs(int[] nums, boolean[] visited, List<Integer> permuation, List<List<Integer>> results) {
        if (nums.length == permuation.size()) {
            results.add(new ArrayList<Integer>(permuation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            permuation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permuation, results);
            // 回溯，尝试然后撤回
            visited[i] = false;
            permuation.remove(permuation.size() - 1);
        }
    }
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        boolean next = true;
        while (next) {
            List<Integer> current = new ArrayList<>();
            for (int a: nums) {
                current.add(a);
            }
            results.add(current);
            next = nextPermutation(nums);
        }
        return results;
    }
    private boolean nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return false;
        }
        int i = n - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = n - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swapItem(nums, j, i - 1);
        swapList(nums, i, n - 1);
        return true;
    }
    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void swapList(int[] nums, int i, int j) {
        while (i < j) {
            swapItem(nums, i, j);
            i++;
            j--;
        }
    }
}
