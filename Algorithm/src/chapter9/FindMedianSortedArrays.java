package chapter9;

public class FindMedianSortedArrays {
//    二分答案的方法，时间复杂度 O(log(range) * (log(n) + log(m)))O(log(range)∗(log(n)+log(m)))
//    其中 range 为最小和最大的整数之间的范围。
//    可以拓展到 Median of K Sorted Arrays
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length + B.length;

        if (n % 2 == 0) {
            return (findKth(A, B, n / 2) + findKth(A, B, n / 2 + 1)) / 2.0;
        }
        return findKth(A, B, n / 2 + 1);
    }
    // k is not zero-based, it starts from 1
    public int findKth(int[] A, int[] B, int k) {
        if (A.length == 0) {
            return B[k - 1];
        }
        if (B.length == 0) {
            return A[k - 1];
        }
        int start = Math.min(A[0], B[0]);
        int end = Math.min(A[A.length - 1], B[B.length - 1]);
        // find first x that >= k numbers is samller or equal to x
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countSmallOrEqual(A, mid) + countSmallOrEqual(B, mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countSmallOrEqual(A, start) + countSmallOrEqual(B, start) >= k) {
            return start;
        }
        return end;
    }
    private int countSmallOrEqual(int[] array, int number) {
        int start = 0, end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] <= number) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (array[start] > number) {
            return start;
        }
        if (array[end] > number) {
            return end;
        }
        return array.length;
    }

    // 分治法
    public double findMedianSortedArrays0(int[] A, int[] B) {
        int n = A.length + B.length;

        if (n % 2 == 0) {
            return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0,  n / 2 + 1)) / 2.0;
        }
        return findKth(A, 0, B, 0, n / 2 + 1);
    }
    // k is not zero-based, it starts from 1
    public int findKth(int[] A, int startOfA, int[] B, int startOfB, int k) {
        if (startOfA >= A.length) {
            return B[startOfB + k - 1];
        }
        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }
        int halfKthOfA = startOfA + k / 2 - 1 < A.length ? A[startOfA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k / 2 - 1 < B.length ? B[startOfB + k / 2 - 1] : Integer.MAX_VALUE;
        if (halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        } else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    }
    public double findMedianSortedArrays1(int[] A, int[] B) {
        return findMedian(new PartialArray(A), new PartialArray(B));
    }
    private double findMedian(PartialArray A, PartialArray B) {
        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.size() == 1 && B.size() == 1) {
                return (A.getMedian() + B.getMedian()) / 2.0;
            }
            PartialArray lowerArr = A;
            int lowerIndex = A.getLowerMedianIndex();
            if (A.getLowerMedian() > B.getLowerMedian()) {
                lowerArr = B;
                lowerIndex = B.getLowerMedianIndex();
            }
            PartialArray upperArr = A;
            int upperIndex = A.getUpperMedianIndex();
            if (A.getUpperMedian() < B.getUpperMedian()) {
                upperArr = B;
                upperIndex = B.getUpperMedianIndex();
            }
            int numOfRemoved = Math.min(lowerArr.getNumOfLower(lowerIndex),upperArr.getNumOfUpper(upperIndex));
            if (lowerArr.get(lowerIndex) == upperArr.get(upperIndex)) {
                return lowerArr.get(lowerIndex);
            }
            lowerArr.removeLower(numOfRemoved);
            upperArr.removeUpper(numOfRemoved);
        }
        if (A.isEmpty()) {
            return B.getMedian();
        }
        return A.getMedian();
    }
}

class PartialArray {
    int[] arr;
    int start, end;
    PartialArray(int[] arr) {
        this.arr = arr;
        this.start = 0;
        this.end = arr.length - 1;
    }
    public int getLowerMedian() {
        return arr[start + (end - start) / 2];
    }
    public int getUpperMedian() {
        return arr[start + (end - start + 1) / 2];
    }
    public double getMedian() {
        return (getUpperMedian() + getLowerMedian()) / 2.0;
    }
    public int getLowerMedianIndex() {
        return start + (end - start) / 2;
    }
    public int getUpperMedianIndex() {
        return start + (end - start + 1) / 2;
    }
    public int size() {
        return end - start + 1;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int getNumOfLower(int index) {
        if (index == start) {
            return 1;
        }
        return index - start;
    }
    public int getNumOfUpper(int index) {
        if (index == end) {
            return 1;
        }
        return end - index;
    }
    public void removeLower(int numOfRemoved) {
        start += numOfRemoved;
    }
    public void removeUpper(int numOfRemoved) {
        end -= numOfRemoved;
    }
    public int get(int index) {
        return arr[index];
    }
}
