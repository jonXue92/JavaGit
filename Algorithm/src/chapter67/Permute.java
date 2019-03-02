package chapter67;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
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
            permuation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permuation, results);
            // 回溯，尝试然后撤回
            visited[i] = false;
            permuation.remove(permuation.size() - 1);
        }
    }
}
