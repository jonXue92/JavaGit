package binaryIndexedTree;

public class BinaryIndexedTree {
    int n;
    int[] A, C;

    public BinaryIndexedTree(int[] nums) {
        this.n = nums.length;
        this.C = new int[n + 1];
        this.A = nums;
        // 初始化
        for (int i = 0; i < n; i++) {
            add(i, A[i]);
        }
    }
    public int lowbit(int x) {
        return x & -x;
    }
    public void update(int i, int val) {
        add(i, val - A[i]);
        A[i] = val;
    }
    public void add(int x, int val) {
        x++;
        for (int i = x; i <= n; i += lowbit(i)) {
            C[i] += val;
        }
    }
    // 递归前缀和
//    public int prefixSum(int x) {
//        if (x == 0) {
//            return 0;
//        } else {
//            return sum(x - lowbit(x)) + C[x];
//        }
//        return x ? C[x]+ sum( x - lowbit(x)):0;
//    }
    // 递归往往实际开销比较大
    public int prefixSum(int x) {
        x++;
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += C[i];
        }
        return res;
    }
    public int sumRange(int i, int j) {
        return prefixSum(j) - prefixSum(i - 1);
    }
}
