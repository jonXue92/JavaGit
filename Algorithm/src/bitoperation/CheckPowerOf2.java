package bitoperation;

public class CheckPowerOf2 {
    boolean checkPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
