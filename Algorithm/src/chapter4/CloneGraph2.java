package chapter4;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph2 {
    public UndirectedGraphnode cloneGraph(UndirectedGraphnode node) {
        if (node == null) {
            return null;
        }
        ArrayList<UndirectedGraphnode> nodes = new ArrayList<>();
        HashMap<UndirectedGraphnode, UndirectedGraphnode> map = new HashMap<>();

        // clone nodes
        nodes.add(node);
        map.put(node, new UndirectedGraphnode(node.label));
        int start = 0;
        while (start < nodes.size())  {
            UndirectedGraphnode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphnode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphnode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }
        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphnode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}
