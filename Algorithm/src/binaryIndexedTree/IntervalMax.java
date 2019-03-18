package binaryIndexedTree;

public class IntervalMax {
    final int MAXN = (int)3e5;
    int[] A = new int[MAXN];
    int[] C = new int[MAXN];
    int m, n;

    public int lowbit(int x) {
        return x & -x;
    }
    public void updata(int x) {
        for (int i = x; i <= n; i += lowbit(i)) {
            C[i] = A[i];
            for (int j = 1; j < lowbit(i); j<<=1) {
                C[i] = Math.max(C[i], C[i - j]);
            }
        }
    }
    public int query(int x, int y) {
        int res = 0;
        while (y >= x) {
            res = Math.max(A[y], res);
            y--;
            for (;y - lowbit(y) >= x; y -= lowbit(y)) {
                res = Math.max(C[y], res);
            }
        }
        return res;
    }
}
