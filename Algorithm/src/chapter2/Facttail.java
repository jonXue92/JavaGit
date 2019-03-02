package chapter2;

import java.util.Scanner;

public class Facttail {
    // 比如n！的计算，之前常用的用递归的方式是n*(n-1)直到1为止
    //而尾递归的方式：初始一个a=1，每次递归是只需维护a=a*n,n=n-1即可，直到n=1时返回a就好了
    static int facttail(int n, int a)
    {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (n == 1)
            return a;
        return facttail(n - 1, n * a);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(facttail(n,1));
    }
}
