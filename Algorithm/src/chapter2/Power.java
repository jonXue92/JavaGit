package chapter2;

public class Power {
    int power(int x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            int tmp = power(x, n / 2);
            return tmp * tmp;
        } else {
            int tmp = power(x, n / 2);
            return tmp * tmp * x;
        }
    }
}
