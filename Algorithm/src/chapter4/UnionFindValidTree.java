package chapter4;

import java.util.HashMap;

public class UnionFindValidTree {
    HashMap<Integer, Integer> father = new HashMap<>();
    UnionFindValidTree(int n) {
        for (int i = 0; i < n; i++) {
            father.put(i, i);
        }
    }
    int compressedFind(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int temp = -1;
        int fa = father.get(x);
        while (fa != father.get(fa)) {
            temp = father.get(fa);
            father.put(fa, parent);
            fa = temp;
        }
        return parent;
    }
    void union(int x, int y) {
        int fa_x = compressedFind(x);
        int fa_y = compressedFind(y);
        if (fa_x != fa_y) {
            father.put(fa_x, fa_y);
        }
    }
}

class Solution_ValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        UnionFindValidTree uf = new UnionFindValidTree(n);
        for (int i = 0; i < edges.length; i++) {
            if (uf.compressedFind(edges[i][0]) == uf.compressedFind(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
