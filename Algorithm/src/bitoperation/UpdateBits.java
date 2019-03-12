package bitoperation;

public class UpdateBits {
    public int updateBits(int n, int m, int i, int j) {
        return ((~((((-1) << (31 - j)) >>> (31 - j + i)) << i)) & n) | (m << i);
    }
    public int updataBits0(int n, int m, int i, int j) {
        int max = ~0; // All 1's
        // 1's through position j, then 0's
        if (j == 31) {
            j = max;
        } else {
            j = (1 << (j + 1)) - 1;
        }
        int left = max - j;
        // 1's after position i
        int right = (1 << i) - 1;
        // 1's, with 0s between i and j
        int mask = left | right;
        // clear i through k, than put m in there
        return ((n & mask) | (m << i));
    }
}
