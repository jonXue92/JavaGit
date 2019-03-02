package chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class StackElement {
    public UndirectedGraphnode node;
    public int neighborIndex;
    public StackElement(UndirectedGraphnode node, int neighborIndex) {
        this.node = node;
        this.neighborIndex = neighborIndex;
    }
}

public class CloneGraph3 {
    public UndirectedGraphnode cloneGraph(UndirectedGraphnode node) {
        if (node == null) {
            return node;
        }
         // use dfs algorithm to traverse the graph and get all nodes
        ArrayList<UndirectedGraphnode> nodes = getNodes(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphnode, UndirectedGraphnode> mapping = new HashMap<>();
        for (UndirectedGraphnode n:nodes) {
            mapping.put(n, new UndirectedGraphnode(n.label));
        }
        // copy neighbors(edges)
        for (UndirectedGraphnode n:nodes) {
            UndirectedGraphnode newNode = mapping.get(n);
            for (UndirectedGraphnode neighbor: n.neighbors) {
                UndirectedGraphnode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }
    private ArrayList<UndirectedGraphnode> getNodes(UndirectedGraphnode node) {
        Stack<StackElement> stack = new Stack<>();
        HashSet<UndirectedGraphnode> set = new HashSet<>();
        stack.push(new StackElement(node, -1));
        set.add(node);
        while (!stack.isEmpty()) {
            StackElement current = stack.peek();
            current.neighborIndex++;
            // there is no more neighbor to traverse for the current node
            if (current.neighborIndex == current.node.neighbors.size()) {
                stack.pop();
                continue;
            }
            UndirectedGraphnode neighbor = current.node.neighbors.get(current.neighborIndex);
            // check if we visited this neighbor before
            if (set.contains(neighbor)) {
                continue;
            }
            stack.push(new StackElement(neighbor, -1));
            set.add(neighbor);
        }
        return new ArrayList<UndirectedGraphnode>(set);
    }
}
