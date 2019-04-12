package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPeakII {
    public List<Integer> findPeakII(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        return find(A, 1, n - 2, 1, m - 2);
    }
    public List<Integer> find(int[][] A, int x1, int x2, int y1, int y2) {
        int mid1 = x1 + (x2 - x1) / 2;
        int mid2 = y1 + (y2 - y1) / 2;
        int x = mid1, y = mid2;
        int max = A[mid1][mid2];
        for (int i = y1; i <= y2; i++) {
            if (A[mid1][i] > max) {
                max = A[mid1][i];
                x = mid1;
                y = i;
            }
        }
        for (int i = x1; i <= x2; i++) {
            if (A[i][mid2] > max) {
                x = i;
                y = mid2;
            }
        }
        boolean isPeak = true;
        if (A[x - 1][y] > A[x][y]) {
            isPeak = false;
            x -= 1;
        } else if (A[x + 1][y] > A[x][y]) {
            isPeak = false;
            x += 1;
        } else if (A[x][y - 1] > A[x][y]) {
            isPeak = false;
            y -= 1;
        } else if (A[x][y + 1] > A[x][y]) {
            isPeak = false;
            y += 1;
        }
        if (isPeak) {
            return new ArrayList<Integer>(Arrays.asList(x, y));
        }
        if (x >= x1 && x < mid1 && y >= y1 && y < mid2) {
            return find(A, x1, mid1 - 1, y1, mid2 - 1);
        }
        if (x >= x1 && x < mid1 && y > mid2 && y <= y2) {
            return find(A, x1, mid1 - 1, mid2 + 1, y2);
        }
        if (x > mid1 && x <= x2 && y >= y1 && y < mid2) {
            return find(A, mid1 + 1, x2, y1, mid2 - 1);
        }
        if (x > mid1 && x <= x2 && y > mid2 && y <= y2) {
            return find(A, mid1 + 1, x2, mid2 + 1, y2);
        }
        return new ArrayList<Integer>(Arrays.asList(-1, -1));
    }
    public List<Integer> findPeakII2(int[][] A) {
        int low = 1, high = A.length - 2;
        List<Integer> ans = new ArrayList<>();
        while (low <= high) {
            int mid = (low + high) / 2;
            int col = find2(mid, A);
            if (A[mid][col] < A[mid + 1][col]) {
                high = mid - 1;
            } else if (A[mid][col] < A[mid + 1][col]) {
                low = mid + 1;
            } else {
                ans.add(mid);
                ans.add(col);
                break;
            }
        }
        return ans;
    }
    public int find2(int row, int[][] A) {
        int col = 0;
        for (int i = 0; i < A[row].length; i++) {
            if (A[row][i] > A[row][col]) {
                col = i;
            }
        }
        return col;
    }
}
