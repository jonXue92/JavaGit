package matrixFastExponentiation;

public class Fibonacci {
    public static class Matrix {
        int[][] value;
        int row, col;
        Matrix(int row, int col) {
            value = new int[row][col];
            this.row = row;
            this.col = col;
        }
        Matrix(int row, int col, int op) {
            value = new int[row][col];
            this.row = row;
            this.col = col;
            int minRowCol = row < col ? row : col;
            for (int i = 0; i < minRowCol; i++) {
                value[i][i] = op;
            }
        }
        Matrix(Matrix matrix) {
            value = new int[matrix.row][matrix.col];
            this.row = matrix.row;
            this.col = matrix.col;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    value[i][j] = matrix.value[i][j];
                }
            }
        }
        Matrix multiply(Matrix matrix) {
            Matrix res = new Matrix(row, col);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < matrix.col; j++) {
                    for (int k = 0; k < col; k++) {
                        res.value[i][j] = res.value[i][j] + value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return res;
        }
        Matrix power(int n) {
            Matrix res = new Matrix(row, col, 1);
            Matrix matrix = new Matrix(this);
            while (n > 0) {
                if (n % 2 == 1) {
                    res = res.multiply(matrix);
                }
                n = n / 2;
                matrix = matrix.multiply(matrix);
            }
            return res;
        }
    }
    public int fibonacci(int n) {
        int  m = n - 1;
        if (m == 0) {
            return 0;
        }
        if (m == 1) {
            return 1;
        }
        Matrix A = new Matrix(2, 2);
        Matrix B = new Matrix(2, 1);
        A.value[0][0] = 1;A.value[0][1] = 1;
        A.value[1][0] = 1;A.value[1][1] = 0;
        B.value[0][0] = 1;
        B.value[1][0] = 0;
        return A.power(m - 1).multiply(B).value[0][0];
    }
}
