package chapter3;

import java.util.*;

class TestCompare implements Comparator<ArraysSortTest> {
    public static Comparator<ArraysSortTest> testcompare = new TestCompare();
    @Override
    public int compare(ArraysSortTest o1, ArraysSortTest o2) {
        // TODO Auto-generated method stub
        if(o1.a < o2.a && o1.b < o2.b) return -1;
        else if(o1.a == o2.a && o1.b < o2.b) return 0;
        return 1;
    }

}
public class ArraysSortTest {
    public int a, b;
    public ArraysSortTest() {}
    public ArraysSortTest(int a,int b) {
        this.a = a;
        this.b = b;
    }
    public static void main(String[] args) {
        String[] str = {"abc", "aaa", "abc"};
        Arrays.sort(str, String.CASE_INSENSITIVE_ORDER); //String中定义的忽略大小写，完全通过字母的顺序进行排序
        for (String s : str) {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(str, Collections.reverseOrder());//反向排序
        for (String s : str) {
            System.out.print(s + " ");
        }
        System.out.println();
        ArraysSortTest[] arrays = {new ArraysSortTest(2,1), new ArraysSortTest(1,2),
                new ArraysSortTest(1,1)};
        Arrays.sort(arrays, TestCompare.testcompare);
        for(ArraysSortTest t : arrays) {
            System.out.println(t.a + " " + t.b);
        }
    }
}
