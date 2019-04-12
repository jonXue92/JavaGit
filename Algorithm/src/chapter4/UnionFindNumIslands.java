package chapter4;

public class UnionFindNumIslands {
    public int[] father = null;
    public int count;
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public UnionFindNumIslands(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
            count--;
        }
    }
    public int query() {
        return count;
    }
    public void set_count(int total) {
        count = total;
    }
}

class Solution {
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        UnionFindNumIslands union_find = new UnionFindNumIslands(n * m);
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    total++;
                }
            }
        }
        union_find.set_count(total);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        union_find.connect(i * m + j, (i - 1) * m + j);
                    }
                    if (i < n - 1 && grid[i + 1][j]) {
                        union_find.connect(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        union_find.connect(i * m + j, i * m + j - 1);
                    }
                    if (j < m - 1 && grid[i][j + 1]) {
                        union_find.connect(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        return union_find.query();
    }
}
