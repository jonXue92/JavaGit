package chapter3;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumTwoPointer {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);

        int L = 0, R = numbers.length - 1;
        while (L < R) {
            if (numbers[L] + numbers[R] == target) {
                int[] pair = new int[2];
                pair[0] = numbers[L];
                pair[1] = numbers[R];
                return pair;
            }
            if (numbers[L] + numbers[R] < target) {
                L++;
            } else {
                R--;
            }
        }
        return null;
    }
}
