package chapter1;

public class StringTest {
    public static void main(String[] args) {
        String H = "hello";
        String H_1 = H;
        String H_2 = "hel";
        String H_3 = H_2 + "lo";
        String H_4 = H_2.concat("lo");

        System.out.println(H);            // hello
        System.out.println(H_1);          // hello
        System.out.println(H_2);          // hel
        System.out.println(H_3);          // hello
        System.out.println(H_4);          // hello

        //==等号测试
        System.out.println(H == H_1);     // true
        System.out.println(H == H_3);     // false
        System.out.println(H == H_4);     // false
        System.out.println(H_3 == H_4);   // false

        //equals函数测试
        System.out.println(H.equals(H_1));   // true
        System.out.println(H.equals(H_3));   // true
        System.out.println(H.equals(H_4));   // true
        System.out.println(H_3.equals(H_4)); // true

        //StringBuilder测试
        StringBuilder helloBuilder = new StringBuilder("hel");
        System.out.println(helloBuilder.equals(H_2));    // false
    }
}