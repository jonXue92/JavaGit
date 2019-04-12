package chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Matrix {
    int[][] v = new int[3][3];
    int d;
    Matrix(int[][] matrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                v[i][j] = matrix[i][j];
            }
        }
    }
    public int contor() {
        int res = 0;
        int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
        for (int i = 0; i < 9; i++) {
            int cnt = 0;
            for (int j = i + 1; j < 9; j++) {
                if (v[j / 3][j % 3] < v[i / 3][i % 3]) {
                    cnt++;
                }
            }
            res += cnt * fac[8 - i];
        }
        return res;
    }
    public Matrix up(int x, int y) {
        if (x == 0) {
            return null;
        }
        Matrix state = new Matrix(this.v);
        state.d = d + 1;
        int t = state.v[x][y];
        state.v[x][y] = state.v[x - 1][y];
        state.v[x - 1][y] = t;
        return state;
    }
    public Matrix down(int x, int y) {
        if (x == 2) {
            return null;
        }
        Matrix state = new Matrix(this.v);
        state.d = d + 1;
        int t = state.v[x][y];
        state.v[x][y] = state.v[x + 1][y];
        state.v[x + 1][y] = t;
        return state;
    }
    public Matrix left(int x, int y) {
        if (y == 0) {
            return null;
        }
        Matrix state = new Matrix(this.v);
        state.d = d + 1;
        int t = state.v[x][y];
        state.v[x][y] = state.v[x][y - 1];
        state.v[x][y - 1] = t;
        return state;
    }
    public Matrix right(int x, int y) {
        if (y == 2) {
            return null;
        }
        Matrix state = new Matrix(this.v);
        state.d = d + 1;
        int t = state.v[x][y];
        state.v[x][y] = state.v[x][y + 1];
        state.v[x][y + 1] = t;
        return state;
    }
}

public class MinMoveStep {
    public String jigsawPuzzle(int[][] matrix) {
        int ans = -1;
        Queue<Matrix> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Matrix ins = new Matrix(matrix);
        queue.offer(ins);
        set.add(ins.contor());
        while (!queue.isEmpty()) {
            Matrix h = queue.poll();
            if (h.contor() == 46233) {
                ans = h.d;
                break;
            }
            int x = 0, y = 0;
            for (int i = 0; i < 9; i++) {
                if (h.v[i / 3][i % 3] == 0) {
                    x = i / 3;
                    y = i % 3;
                    break;
                }
            }
            Matrix state;
            state = h.up(x, y);
            if (state != null && !set.contains(state.contor())) {
                set.add(state.contor());
                queue.offer(state);
            }
            state = h.down(x, y);
            if (state != null && !set.contains(state.contor())) {
                set.add(state.contor());
                queue.offer(state);
            }
            state = h.left(x, y);
            if (state != null && !set.contains(state.contor())) {
                set.add(state.contor());
                queue.offer(state);
            }
            state = h.right(x, y);
            if (state != null && !set.contains(state.contor())) {
                set.add(state.contor());
                queue.offer(state);
            }
        }
        if (ans != -1) {
            return "YES";
        } else {
            return "NO" ;
        }
    }
}
