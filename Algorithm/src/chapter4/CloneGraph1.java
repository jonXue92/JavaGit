package chapter4;

import java.util.*;

class UndirectedGraphnode {
    int label;
    ArrayList<UndirectedGraphnode> neighbors;
    UndirectedGraphnode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph1 {
    public  UndirectedGraphnode cloneGraph(UndirectedGraphnode node) {
        if (node == null) {
            return node;
        }
        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphnode> nodes = getNodes(node);

        // copy nodes, store the old->new mapping information in a hashmap
        HashMap<UndirectedGraphnode, UndirectedGraphnode> mapping =  new HashMap<>();
        for (UndirectedGraphnode n: nodes) {
            mapping.put(n, new UndirectedGraphnode(n.label));
        }

        // copy neighbors(edges)
        for (UndirectedGraphnode n: nodes) {
            UndirectedGraphnode newNode = mapping.get(n);
            for (UndirectedGraphnode neighbor: n.neighbors) {
                UndirectedGraphnode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    private ArrayList<UndirectedGraphnode> getNodes(UndirectedGraphnode node) {
        Queue<UndirectedGraphnode> queue = new LinkedList<>();
        HashSet<UndirectedGraphnode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphnode head = queue.poll();
               for(UndirectedGraphnode neighbor: head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphnode>(set);
    }
}
