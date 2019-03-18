package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static boolean cubicSumTest(int start, int end, int sum) {
        if (start == end) {
            return false;
        }
        long right = sum * sum * sum;
        // 1^3 + 2^3 + ... + n^3 = (n*(n+1)/2)^2;
        // a^3 + ... + b^3 = (b*(b+1)/2)^2 - ((a - 1)*a/2)^2;
        long first = end * end * (end + 1) * (end + 1) / 4;
        long second = (start - 1) * (start - 1) * start * start / 4;
        return right + second - first == 0;
    }
    public static List<List<Integer>> cubicSumList(int max) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 3; i <= max; i++) {
            // c^3 = a^3 + ... + b^3 = (b*(b+1)/2)^2 - ((a - 1)*a/2)^2 <= (b*(b+1)/2)^2;
            // b <= (2 * c^(3/2) + 0.25)^(0.5) - 0.5;
            double down = Math.sqrt(2 * Math.sqrt(i * i * i)+ 0.25) - 0.5;
            for (int j = i - 1; j >= (int)down; j--) {
                // a = 0.5 + (0.25 + 2* ((b*(b+1)/2)^2-c^3)^0.5)^0.5;
                double up = 0.5 + Math.sqrt(0.25 + 2 * Math.sqrt(j * j * (j + 1) * (j + 1) / 4.0 - i * i * i));
                for (int k = (int)up; k <= (int)up + 1; k++) {
                    if (cubicSumTest(k, j, i)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(k);
                        temp.add(j);
                        temp.add(i);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = in.nextInt();
        List<List<Integer>> res = cubicSumList(max);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).get(0) + "^3 + ... + " + res.get(i).get(1) + "^3 = " + res.get(i).get(2) + "^3");
        }
    }
}
