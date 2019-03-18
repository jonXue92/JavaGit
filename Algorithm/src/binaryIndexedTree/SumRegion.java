package binaryIndexedTree;

public class SumRegion {
    int[][] C, A;
    int m, n;
    public SumRegion(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        C = new int[m + 1][n + 1];
        A = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    public int lowbit(int x) {
        return x & -x;
    }
    public void add(int row, int col, int val) {
        row++;
        col++;
        for (int i = row; i <= m; i += lowbit(i)) {
            for (int j = col; j <= n; j += lowbit(j)) {
                C[i][j] += val;
            }
        }
    }
    public void update(int row, int col, int val) {
        row++;
        col++;
        int delta = val - A[row][col];
        A[row][col] = val;
        for (int i = row; i <= m; i += lowbit(i)) {
            for (int j = col; j <= n; j += lowbit(j)) {
                C[i][j] += delta;
            }
        }
    }
    public int sum(int row, int col) {
        row++;
        col++;
        int res = 0;
        for (int i = row; i > 0; i -= lowbit(i)) {
            for (int j = col; j > 0; j -= lowbit(j)) {
                res += C[i][j];
            }
        }
        return res;
    }
    public int SumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }
}
