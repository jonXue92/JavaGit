package chapter4;

public class Fibonacci {
    public static int fibonacci(int n) {
        // write your code here
        return tailFibonacci(n, 0, 1);
    }
    public static int tailFibonacci(int n, int forward1, int forward2 ) {
        if (n <= 1){
            return forward1;
        }
        return tailFibonacci(n-1, forward2 , forward1 + forward2);
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
