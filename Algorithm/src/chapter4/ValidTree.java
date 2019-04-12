package chapter4;

import java.util.*;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }
        // 因为在n个节点，n-1条边的情况下，只有两种可能：1、树 2、几个有环的不联通的图 因此从节点0出发，最后得到的hash size不是n的话，一定不是树
        Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor: graph.get(node)) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return (set.size() == n);
    }
    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}
