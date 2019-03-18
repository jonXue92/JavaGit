package backpack;

public class Backpack2 {
    // 枚举法：O(n*2^n)
    public int backpack20(int m, int[] A, int[] V) {
        int n = A.length;
        int lim = 1 << n;
        int ans = 0;
        for (int s = 0; s < lim; s++) {
            int tA = 0, tV = 0;
            for(int j = 0; j < n; j++) {
                if ((s >> j) % 2 == 1) {
                    tA += A[j];
                    tV += V[j];
                }
            }
            if (tA <= m && tV > ans) {
                ans = tV;
            }
        }
        return ans;
    }
    // 贪心法：有错误。时间复杂度O(nlgn)排序+O(n)贪心
    // DP 空间复杂度O(NV)
    public int backpack21(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] backpack = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                backpack[i + 1][j] = backpack[i][j];
                if (j > A[i]) {
                    backpack[i + 1][j] = Math.max(backpack[i][j], backpack[i][j - A[i]] + V[i]);
                }
            }
        }
        return backpack[n][m];
    }
    // DP O(V)
    public int backpack22(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] backpack = new int[2][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int index = i & 1;
                backpack[index][j] = backpack[index ^ 1][j];
                if (j >= A[i]) {
                    backpack[index][j] = Math.max(backpack[index ^ 1][j], backpack[index ^ 1][j - A[i]] + V[i]);
                }
            }
        }
        return backpack[n][m];
    }
    public int backpack23(int m, int[] A, int[] V) {
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        return f[m];
    }
    public int backpackII(int m, int[] A, int[] V) {
        int n = A.length;
        int[][] bp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                bp[i][j] = bp[i - 1][j];
                if (j >= A[i - 1]) {
                    bp[i][j] = Math.max(bp[i - 1][j] , bp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return bp[n][m];
    }
}
