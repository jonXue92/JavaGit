package segmentTree;

class SegmentTreeNode {
    public int start, end, max;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = this.right = null;
    }
}

public class SegmentTree {
    public SegmentTreeNode build(int[] A) {
        return buildhelper(0, A.length - 1, A);
    }
    public SegmentTreeNode buildhelper(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = start + (end - start) / 2;
        node.left = buildhelper(start, mid, A);
        node.right = buildhelper(mid + 1, end, A);
        node.max = Math.max(node.left.max, node.right.max);
        return node;
    }
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == root.end && root.start == index) { // 找到被改动的叶子结点
            root.max = value; // 改动value值
            return;
        }
        int mid = root.start + (root.end - root.start) / 2; // 将当前节点区间分割为2个区间的分割线
        if (index <= mid) { // 如果index在当前结点的左边
            modify(root.left, index, value); // 递归操作
        } else { // 如果index在当前结点的右边
            modify(root.right, index, value);
        }
        root.max = Math.max(root.right.max, root.left.max); // 可能对当前节点的影响
        return;
    }
    public int query(SegmentTreeNode root, int start, int end) {
        if (start <= root.start && root.end <= end) {
            // 如果当前节点的区间在查询区间之内，直接输出结果
            return root.max;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int ans = Integer.MIN_VALUE;
        if (mid >= start) { // 如果查询区间和左边的区间有交集，则寻找查询区间在左边区间上的最大值
            ans = Math.max(ans, query(root.left, start, end));
        }
        if (mid + 1 <= end) {
            ans = Math.max(ans, query(root.right, start, end));
        }
        return ans;
    }
}
