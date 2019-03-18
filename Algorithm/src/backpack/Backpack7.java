package backpack;

public class Backpack7 {
    public int backPackvii0(int n, int[] prices, int[] weight, int[] amounts) {
        int all = prices.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= all; i++) {
            for (int k = 1; k <= amounts[i - 1]; k++) {
                for (int j = n; j >= prices[i - 1]; j--) {
                    f[j] = Math.max(f[j], f[j - prices[i - 1]] + weight[i - 1]);
                }
            }
}
        return f[n];
    }
    public int backPackvii1(int n, int[] prices, int[] weight, int[] amounts) {
        int all = prices.length;
        int[][] bp = new int[all + 1][n + 1];
        for (int i = 1; i <= all; i++) {
            for (int j = 0; j <= n; j++) {
                bp[i][j] = bp[i - 1][j];
                for (int k = 1; k <= amounts[i - 1]; k++) {
                    if (j >= k * prices[i - 1]) {
                        bp[i][j] = Math.max(bp[i][j], bp[i - 1][j - k * prices[i - 1]] + k * weight[i - 1]);
                    }
                }
            }
        }
        return bp[all][n];
    }
}
