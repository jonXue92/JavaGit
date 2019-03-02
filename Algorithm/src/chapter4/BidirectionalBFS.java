package chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BidirectionalBFS {
    public int doubleBFS(UndirectedGraphnode start, UndirectedGraphnode end) {
        if (start.equals(end)) {
            return 1;
        }
        // 起点开始的BFS队列
        Queue<UndirectedGraphnode> startQueue = new LinkedList<>();
        // 终点开始的BFS队列
        Queue<UndirectedGraphnode> endQueue = new LinkedList<>();
        startQueue.offer(start);
        endQueue.offer(end);
        int step = 0;
        // 记录从起点开始访问到的节点
        HashSet<UndirectedGraphnode> startVisited = new HashSet<>();
        // 记录从终点开始访问到的节点
        HashSet<UndirectedGraphnode> endVisited = new HashSet<>();
        startVisited.add(start);
        endVisited.add(end);
        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            int startSize = startQueue.size();
            int endSize = endQueue.size();
            // 按层遍历
            step++;
            for (int i = 0; i < startSize; i++) {
                UndirectedGraphnode cur = startQueue.poll();
                for (UndirectedGraphnode neighbor: cur.neighbors) {
                    if (startVisited.contains(neighbor)) { //重复节点
                        continue;
                    } else if (endVisited.contains(neighbor)) {// 相交
                        return step;
                    } else {
                        startVisited.add(neighbor);
                        startQueue.offer(neighbor);
                    }
                }
            }
            step++;
            for (int i = 0; i < endSize; i++) {
                UndirectedGraphnode cur = endQueue.poll();
                for (UndirectedGraphnode neighbor: cur.neighbors) {
                    if (endVisited.contains(neighbor)) {
                        continue;
                    } else if (startVisited.contains(neighbor)) {
                        return step;
                    } else {
                        endVisited.add(neighbor);
                        endQueue.offer(neighbor);
                    }
                }
            }
        }
        return -1;// 不连通
    }
}
