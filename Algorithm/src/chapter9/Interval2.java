package chapter9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Interval2 {
    int left, right;
    Interval2(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        List<Interval2> A = new ArrayList<>();
        A.add(new Interval2(1, 7));
        A.add(new Interval2(5, 6));
        A.add(new Interval2(3, 4));
        System.out.println("Before sort: ");
        for (Interval2 i : A) {
            System.out.println("(" + i.left + ", " + i.right + ")");
        }
        A.sort(new MyCmp());
        System.out.println("After sort: ");
        for (Interval2 i : A) {
            System.out.println("(" + i.left + ", " + i.right + ")");
        }
    }
}
class MyCmp implements Comparator<Interval2> {
    @Override
    public int compare(Interval2 o1, Interval2 o2) {
        return o1.left - o2.left;
    }
}
