package binaryIndexedTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReversePairs {
    class BITNode {
        public int index;
        public int val;
        public BITNode(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public int lowbit(int x) {
        return x & -x;
    }
    public void update(int index, int val, int[] BIT) {
        for (int i = index + 1; i < BIT.length; i += lowbit(i)) {
            BIT[i] += val;
        }
    }
    public int getPrefixSum(int index, int[] BIT) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= lowbit(i)) {
            sum += BIT[i];
        }
        return sum;
    }
    public long reversePairs(int[] A) {
        if (A == null || A.length == 0) {
            return (long)0;
        }
        List<BITNode> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(new BITNode(i, A[i]));
        }
        Collections.sort(list, new Comparator<BITNode>() {
            @Override
            public int compare(BITNode o1, BITNode o2) {
                return o1.val - o2.val;
            }
        });
        // 离散化
        A[list.get(0).index] = 0;
        for (int i = 0; i < A.length; i++) {
            if (list.get(i).val == list.get(i - 1).val) {
                A[list.get(i).index] = i - 1;
            } else {
                A[list.get(i).index] = i;
            }
        }
        long count = 0;
        int[] BIT = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            update(A[i], 1, BIT);
            count += getPrefixSum(A.length - 1, BIT) - getPrefixSum(A[i], BIT);
        }
        return count;
    }
}
