package hello;

import java.util.Scanner;

public class Char1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		char c = '\u0041';
//		char c = 65;
		// 16����
		char d = (char)(c+'a'-'A');
		System.out.println(c);
		System.out.println(d);
		System.out.println('A'>'a');
		System.out.println('��'>'A');
		//�����ַ�
		System.out.println("abc\bd");//eclipse ����\b
		System.out.println("abt\tt12s");
		System.out.println("a\t123");
		System.out.println(Math.abs(-12));
	}

}
