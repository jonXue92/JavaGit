package chapter4;

import java.util.*;

public class UnionFindConnectedSet {
    HashMap<Integer, Integer> father = new HashMap<>();
    UnionFindConnectedSet(HashSet<Integer> hashSet) {
        for (Integer now: hashSet) {
            father.put(now, now);
        }
    }
    int find(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int next;
        while (x != father.get(x)) {
            next = father.get(x);
            father.put(x, parent);
            x = next;
        }
        return parent;
    }
    void union(int x, int y) {
        int fa_x = find(x);
        int fa_y = find(y);
        if (fa_x != fa_y) {
            father.put(fa_x, fa_y);
        }
    }
}

class Solution_connectedSet {
    List<List<Integer>> print(HashSet<Integer> hashSet, UnionFindConnectedSet uf, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i : hashSet) {
            int fa = uf.find(i);
            if (!hashMap.containsKey(fa)) {
                hashMap.put(fa, new ArrayList<Integer>());
            }
            List<Integer> now = hashMap.get(fa);
            now.add(i);
            hashMap.put(fa, now);
        }
        for (List<Integer> now: hashMap.values()) {
            Collections.sort(now);
            ans.add(now);
        }
        return ans;
    }
    public List<List<Integer>> connectedSet(List<UndirectedGraphnode> nodes) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (UndirectedGraphnode now: nodes) {
            hashSet.add(now.label);
            for (UndirectedGraphnode neighbour: now.neighbors) {
                hashSet.add(neighbour.label);
            }
        }
        UnionFindConnectedSet uf = new UnionFindConnectedSet(hashSet);
        for (UndirectedGraphnode now: nodes) {
            for (UndirectedGraphnode neighbor: now.neighbors) {
                int fnow = uf.find(neighbor.label);
                int fneighbor = uf.find(neighbor.label);
                if (fnow != fneighbor) {
                    uf.union(now.label, neighbor.label);
                }
            }
        }
        return print(hashSet, uf, nodes.size());
    }
}