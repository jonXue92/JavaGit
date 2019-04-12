package chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Subarray {
    public int maxSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int prefixSum = 0, minPrefixSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }
        return maxSum;
    }
    public int minSubarray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return Integer.MAX_VALUE;
        }
        int prefixSum = 0, maxPrefixSum = 0, minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums.get(i);
            minSum = Math.min(minSum, prefixSum - maxPrefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
        }
        return minSum;
    }
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(prefixSum, 0);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum)) {
                res.add(map.get(prefixSum));
                res.add(i);
                return res;
            }
            map.put(prefixSum, i + 1);
        }
        return res;
    }
    private class Pair {
        int pSum;
        int i;
        public Pair(int prefixSum, int index) {
            this.pSum = prefixSum;
            this.i = index;
        }
    }
    private Comparator<Pair> compartor = new Comparator<Pair>() {
        public int compare(Pair pair1, Pair pair2) {
            return pair1.pSum - pair2.pSum;
        }
    };
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] prefixSum = new Pair[nums.length + 1];
        prefixSum[0] = new Pair(0, 0);
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = new Pair(prefixSum[i].pSum + nums[i], i + 1);
        }
        Arrays.sort(prefixSum, compartor);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i + 1].pSum - prefixSum[i].pSum < min) {
                min = prefixSum[i + 1].pSum - prefixSum[i].pSum;
                int[] temp = new int[]{prefixSum[i + 1].i, prefixSum[i].i};
                Arrays.sort(temp);
                res[0] = temp[0];
                res[1] = temp[1] - 1;
            }
        }
        return res;
    }
}
