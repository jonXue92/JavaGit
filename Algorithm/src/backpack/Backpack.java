package backpack;

public class Backpack {
    public int backpackI0(int m, int[] A) {
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }
    // dp[i]来表示能否从n件物品中选出若干件是他们的体积和达到i
    public int backpackI1(int m, int[] A) {
        int n = A.length;
        int res = 0;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= A[i - 1]; j--) {
                if (dp[j - A[i - 1]]) {
                    dp[j] = true;
                    if (j > res) {
                        res = j;
                    }
                }
            }
        }
        return res;
    }
}
