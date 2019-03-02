package chapter2;

public class PowerNoRecu {
    int power(int x, int n) {
        int ans = 1, base = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= base;
            }
            base *= base;
            n = n / 2;
        }
        return ans;
    }
}
