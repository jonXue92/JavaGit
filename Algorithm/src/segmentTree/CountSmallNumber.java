package segmentTree;

import java.util.ArrayList;
import java.util.List;

public class CountSmallNumber {
    class SegmentTreeNode {
        public int start, end;
        public int count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
    SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start == end) {
            root.count = 0;
        } else {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        return root;
    }
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && end == root.end) {
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftCount = 0, rightCount = 0;
        if (start <= mid) {
            if (mid < end) {
                leftCount = querySegmentTree(root.left, start, mid);
            } else {
                leftCount = querySegmentTree(root.left, start, end);
            }
        }
        if (mid + 1 <= end) {
            if (start <= mid) {
                rightCount = querySegmentTree(root.right, mid + 1, end);
            } else {
                rightCount = querySegmentTree(root.right, start, end);
            }
        }
        return leftCount + rightCount;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.count += value;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid + 1 <= index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.count = root.left.count + root.right.count;
    }
    public List<Integer> countOfSmallerNumberII(int[] A) {
        root = build(0, 10000);
        List<Integer> ans = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = 0;
            if (A[i] > 0) {
                res = querySegmentTree(root, 0, A[i] - 1);
            }
            modifySegmentTree(root, A[i], 1);
            ans.add(res);
        }
        return ans;
    }
}
