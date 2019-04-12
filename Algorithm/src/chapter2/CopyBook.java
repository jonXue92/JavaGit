package chapter2;

public class CopyBook {
    public int[][] f;
    public int[] A;
    public int n, K;

    public void calc(int k, int i) {
        if (f[k][i] != -1) {
            return;
        }
        if (k == 0) {
            f[k][i] = i == 0 ? 0 : Integer.MAX_VALUE;
            return;
        }
        if (i == 0) {
            f[k][i] = 0;
            return;
        }
        f[k][i] = Integer.MAX_VALUE;
        int s = 0;
        for (int j = i; j >= 0; j--) {
            calc(k - 1, j);
            f[k][j] = Math.min(Math.max(s, f[k - 1][j]), f[k][j]);
            if (j > 0) {
                s += A[j - 1];
            }
        }
    }
    public int copyBooksMS(int[] AA, int KK) {
        A = AA;
        n = A.length;
        K = KK;
        if (n == 0) {
            return 0;
        }
        if (K < n) {
            K = n;
        }
        f = new int[K + 1][n + 1];
        int i, j, k, s;
        for (i = 0; i <= K; i++) {
            for (j = 0; j <= n; j++) {
                f[i][j] = -1;
            }
        }
        calc(K, n);
        return f[K][n];
    }

    public int copyBooksDP(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int i, j, k ,sum;
        int[][] f = new int[2][n + 1];
        int old, now = 0;
        for (i = 0; i <= n; i++) {
            f[now][i] = Integer.MAX_VALUE;
        }
        f[now][0] = 0;
        for (i = 1; i <= K; i++) {
            old = now;
            now = 1 - now;
            for (j = 0; j <= n; j++) {
                sum = 0;
                for (k = j; k >= 0; k--) {
                    if (f[old][k] < Integer.MAX_VALUE) {
                        f[now][j] = Math.min(f[now][j], Math.max(sum, f[old][k]));
                    }
                    if (k > 0) {
                        sum += A[k - 1];
                    }
                }
            }
        }
        return f[now][n];
    }
}
