package chapter3;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(target - numbers[i])) {
                int[] pair = new int[2];
                pair[0] = numbers[i];
                pair[1] = target - numbers[i];
                return pair;
            }
            set.add(numbers[i]);
        }

        return null;
    }
}
