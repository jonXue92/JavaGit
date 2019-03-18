package matrixFastExponentiation;

public class Matrix {
    int[][] value;
    int row, col;
    Matrix(int row, int col) {
        value = new int[row][col];
        this.row = row;
        this.col = col;
    }
    //计算矩阵的幂中矩阵的行的个数和列的个数必须是相等的，因此这里为了防止列不等于行，就做了一个int minRowCol = row < col ? row : col;操作
    //这是一个构造函数，其中op是初始化矩阵中对角线上的数值;比如说我们要初始化一个3乘3的单位矩阵，就是Matrx(3, 3, 1)
    // 而value[i][i] = op;是为对角线上的元素赋值
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
