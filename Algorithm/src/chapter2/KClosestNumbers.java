package chapter2;

public class KClosestNumbers {
    public int[] kClosetNumbers(int[] A, int target, int k) {
        int left = findLowerCloset(A, target);
        int right = left + 1;
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(A, target, left, right)) {
                results[i] = A[left];
                left--;
            } else {
                results[i] = A[right];
                right++;
            }
        }
        return results;
    }
    private boolean isLeftCloser(int[] A, int target, int left, int right) {
        if (left < 0) {
            return false;
        }
        if (right >= A.length) {
            return true;
        }
        return target - A[left] <= A[right] - target;
    }
    private int findLowerCloset(int[] A, int target) {
        // find the last element smaller than target
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] < target) {
            return end;
        }
        if (A[start] < target) {
            return start;
        }
        return -1;
    }
}
