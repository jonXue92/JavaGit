package hello;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int f;
		double tem;
		f = in.nextInt();
		tem = (f - 32) / 9.0 * 5;
		System.out.println((int)tem);
	}

}
