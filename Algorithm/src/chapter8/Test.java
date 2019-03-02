package chapter8;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static int[] topk(int[] nums, int k) {
        int[] res = new int[k];
        Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer number1, Integer number2) {
                return number1 - number2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        System.out.println(heap.size());
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
        // PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
        //      public int compare(Integer o1, Integer o2) {
        //          return o1 - o2;
        //      }
        //  });

        //  for (int i : nums) {
        //      minheap.add(i);
        //      if (minheap.size() > k) {
        //         minheap.poll();
        //      }
        //  }

        //  int[] result = new int[k];
        //  for (int i = 0; i < result.length; i++) {
        //      result[k - i - 1] = minheap.poll();
        //  }
        //  return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 10, 1000, -99, 4, 100};
        int[] res = topk(nums, 3);
        for (int i: res) {
            System.out.println(i + " ");
        }
    }
}
