package chapter4;

public class DFSNumIslands {
    public int m, n;
    public void dfs(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j]) {
            grid[i][j] = false;
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                ans++;
                dfs(grid, i, j);
            }
        }
        return ans;
    }
}
