package hello;

import java.util.Scanner;

public class Char1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		char c = '\u0041';
//		char c = 65;
		// 16进制
		char d = (char)(c+'a'-'A');
		System.out.println(c);
		System.out.println(d);
		System.out.println('A'>'a');
		System.out.println('汉'>'A');
		//逃逸字符
		System.out.println("abc\bd");//eclipse 不做\b
		System.out.println("abt\tt12s");
		System.out.println("a\t123");
		System.out.println(Math.abs(-12));
	}

}
