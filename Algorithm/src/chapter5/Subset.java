package chapter5;

import java.util.*;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, results);
    }
    public List<List<Integer>> subsets0(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        for(int i:nums) {
            helper0(i,result);
        }
        return result;
    }
    private void helper0(int num,List<List<Integer>> result) {
        int size = result.size();
        for(int i = 0; i < size; i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>(result.get(i));
            subset.add(num);
            result.add(new ArrayList<Integer>(subset));
        }
    }
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        dfs1(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    private void dfs1(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
//        results.add(subset);
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
//            List<Integer> newSet = new ArrayList<>(subset);
//            newSet.add(nums[i]);
//            dfs(nums, i + 1,newSet, results);
            subset.add(nums[i]);
            dfs(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
    public List<List<Integer>> subset2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        // BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<Integer>());
        while (!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            results.add(subset);
            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new LinkedList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.offer(nextSubset);
                }
            }
        }
        return results;
    }
    public List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        // 1 << n is 2^n
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}