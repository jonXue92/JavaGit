package chapter2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int num='a';
        System.out.println("num='a':num=="+num);
        char ch=97;
        System.out.println("ch=97:ch=="+ch);
        System.out.println(Character.SIZE);
        char ch1='\u0055';//16进制
        System.out.println(ch1);
        int unicode=(int)ch1;
        System.out.println(unicode);
        char ch2='6';
        System.out.println((int)(ch2-'0'));
    }
}
