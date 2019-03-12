package segmentTree;

public class IntervalSum2 {

    class SegmentTreeNode {
        public int start, end;
        public int sum;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }

    SegmentTreeNode root;

    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start == end) {
            root.sum = A[start];
        } else {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftSum = 0, rightSum = 0;
        // 左子区
        if (mid >= start) {
            if (mid < end) { // 分裂
                leftSum = querySegmentTree(root.left, start, mid);
            } else { // 包含
                leftSum = querySegmentTree(root.left, start, end);
            }
        }
        if (mid + 1 <= end) {
            if (start < mid + 1) { // 分裂
                rightSum = querySegmentTree(root.right, mid + 1, end);
            } else {
                rightSum = querySegmentTree(root.right, start, end);
            }
        }
        return leftSum + rightSum;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        // 查询
        int mid = root.start + (root.end - root.start) / 2;
        // 对于单点修改来说，start, end 和 index 判断是可以不写的;因为只要确保要修改的点能落在对应的区间就可以了
        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid + 1 <= index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    public IntervalSum2(int[] A) {
        root = build(0, A.length - 1, A);
    }
    public long query(int start, int end) {
        return querySegmentTree(root, start, end);
    }
    public void modify(int index, int value) {
        modifySegmentTree(root, index, value);
    }
}
