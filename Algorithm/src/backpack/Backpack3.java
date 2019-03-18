package backpack;

public class Backpack3 {
    public int backpackIII0(int[] A, int[] V, int m) {
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k * A[i] <= m; k++) {
                for (int j = m; j >= A[i]; j--) {
                    f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
                }
            }
        }
        return f[m];
    }
    public int backpackIII1(int[] A, int[] V, int m) {
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = A[i]; j <= m; j++) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        return f[m];
    }
}
