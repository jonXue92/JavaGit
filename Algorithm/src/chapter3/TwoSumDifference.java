package chapter3;

import java.util.Arrays;
import java.util.Comparator;

class Pair {
    public int idx, num;
    public Pair(int i, int n) {
        this.idx = i;
        this.num = n;
    }
}

public class TwoSumDifference {
    public int[] twoSumDifference (int[] nums, int target) {
//        Arrays.sort(nums);
//        target = Math.abs(target)
//
//        // 下面这个部分的代码是 O(n) 的
//        int j = 1;
//        for (int i = 0; i < nums.length; i++) {
//            while (j < nums.length && nums[j] - nums[i] < target) {
//                j++;
//            }
//            if (nums[j] - nums[i] == target) {
//                // 找到答案!
//            }
//        }
        int[] indexs = new int[2];
        if (nums == null || nums.length < 2)
            return indexs;

        if (target < 0)
            target = -target;

        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i)
            pairs[i] = new Pair(i, nums[i]);

        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.num - p2.num;
            }
        });

        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (i == j)
                j ++;
            while (j < n && pairs[j].num - pairs[i].num < target)
                j ++;

            if (j < n && pairs[j].num - pairs[i].num == target) {
                indexs[0] = pairs[i].idx + 1;
                indexs[1] = pairs[j].idx + 1;
                if (indexs[0] > indexs[1]) {
                    int temp = indexs[0];
                    indexs[0] = indexs[1];
                    indexs[1] = temp;
                }
                return indexs;
            }
        }
        return indexs;
    }
}
