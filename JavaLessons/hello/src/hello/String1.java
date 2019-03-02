package hello;

import java.util.Scanner;

public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = new String("a string");
		String ss = "hello ";
		System.out.println(ss+s+12+24);
		System.out.println(s+ss+(12+24));
//		String a;
//		s=in.next();
//		s=in.nextLine();
//		System.out.println(s);
//		System.out.println(s=="bye");
//		System.out.println(s.equals("bye"));
		String s1 = "abc";
		String s2 = "abcd";
		System.out.println("abcd".compareTo(s2));
		System.out.println(s1.charAt(0));
		String s3 = "123456789ºº×Ö";
		System.out.println(s3.substring(2));
		System.out.println(s3.substring(2, 4));
		System.out.println(s3.indexOf("9ºº"));
		System.out.println(s3.lastIndexOf(9));
		String s4 = "abcd";
		String s5 = s4.toUpperCase();
		System.out.println(s4);
		System.out.println(s5);
	}

}
