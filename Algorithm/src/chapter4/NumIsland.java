package chapter4;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int x, y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumIsland {
    public int numIsland(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        boolean[][] v = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] && !v[i][j]) {
                    bfs(grid, v, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void bfs(boolean[][] grid, boolean[][] v, int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        v[x][y] = true;
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                Coordinate adj = new Coordinate(coor.x + dx[i], coor.y + dy[i]);
                if (!isBound(adj, grid)) {
                    continue;
                }
                if (grid[adj.x][adj.y] && !v[adj.x][adj.y]) {
                    v[adj.x][adj.y] = true;
                    queue.offer(adj);
                }
            }
        }
    }
    private boolean isBound(Coordinate coor, boolean[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}
