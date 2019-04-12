package chapter2;

public class SearchMatrix {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        int count = 0;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
}
