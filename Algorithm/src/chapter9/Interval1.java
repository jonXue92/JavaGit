package chapter9;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.sort;

public class Interval1 implements Comparable<Interval1> {
    int left, right;
    Interval1(int left, int right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public int compareTo(Interval1 o) {
        return this.left - o.left;
    }

    public static void main(String[] args) {
        List<Interval1> A = new ArrayList<>();
        A.add(new Interval1(1, 7));
        A.add(new Interval1(5, 6));
        A.add(new Interval1(3, 4));
        System.out.println("Before sort: ");
        for (Interval1 i : A) {
            System.out.println("(" + i.left + ", " + i.right + ")");
        }
        sort(A);
        System.out.println("After sort: ");
        for (Interval1 i : A) {
            System.out.println("(" + i.left + ", " + i.right + ")");
        }
    }
}
