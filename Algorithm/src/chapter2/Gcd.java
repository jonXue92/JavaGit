package chapter2;

public class Gcd {
    public int gcd(int big, int small) {
        if (small != 0) {
            return gcd(small, big % small);
        } else {
            return big;
        }
    }
}
