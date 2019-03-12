package bitoperation;

public class BitSwapRequired {
    public int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    public int bitSwapRequired(int a, int b) {
        return countOnes(a ^ b);
    }
}
