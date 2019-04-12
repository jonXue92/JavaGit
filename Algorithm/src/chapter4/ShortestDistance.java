package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistance {
    public int[][] grid;
    public int n, m;
    public int[] deltaX = {0,0,1,-1};
    public int[] deltaY = {1,-1,0,0};
    private List<Coordinate> getCoordinates(int type) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == type) {
                    coordinates.add(new Coordinate(i, j));
                }
            }
        }
        return coordinates;
    }
    private void setGrid(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;
    }
    private boolean inBound(Coordinate coor) {
        if (coor.x < 0 || coor.x >= n) {
            return false;
        }
        if (coor.y < 0 || coor.x >= m) {
            return false;
        }
        return grid[coor.x][coor.y] == 0;
    }
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        setGrid(grid);
        List<Coordinate> houses = getCoordinates(1);
        int[][] distanceSum = new int[n][m];
        int[][] visitedTimes = new int[n][m];
        for (Coordinate house: houses) {
            bfs(house, distanceSum, visitedTimes);
        }
        int shortest = Integer.MAX_VALUE;
        List<Coordinate> empties = getCoordinates(0);
        for (Coordinate empty: empties) {
            if (visitedTimes[empty.x][empty.y] != houses.size()) {
                continue;
            }
            shortest = Math.min(shortest, distanceSum[empty.x][empty.y]);
        }
        if (shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }
    private void bfs(Coordinate start, int[][] distanceSum, int[][] visitedTimes) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] hash = new boolean[n][m];
        queue.offer(start);
        hash[start.x][start.y] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int temp = 0; temp < size; temp++) {
                Coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate adj = new Coordinate(coor.x + deltaX[i], coor.y + deltaY[i]);
                    if (!inBound(adj)) {
                        continue;
                    }
                    if (hash[adj.x][adj.y]) {
                        continue;
                    }
                    queue.offer(adj);
                    hash[adj.x][adj.y] = true;
                    distanceSum[adj.x][adj.y] += steps;
                    visitedTimes[adj.x][adj.y]++;
                }
            }
        }
    }
    public int shorestDistance2(int [][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.min(ans, bfs2(grid, new Coordinate(i, j)));
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int bfs2(int[][] grid, Coordinate coor) {
        Queue<Coordinate> q = new LinkedList<>();
        boolean[][] v = new boolean[grid.length][grid[0].length];
        q.offer(coor);
        v[coor.x][coor.y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int dist = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && !v[nx][ny]) {
                        v[nx][ny] = true;
                        if (grid[nx][ny] == 1) {
                            sum += dist;
                        }
                        if (grid[nx][ny] == 0) {
                            q.offer(new Coordinate(nx, ny));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !v[i][j]) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return sum;
    }
}
