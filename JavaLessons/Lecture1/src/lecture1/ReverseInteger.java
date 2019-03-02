package lecture1;

import java.util.Scanner;

public class ReverseInteger {

	public static int reverseInteger(int number) {
		StringBuilder sb = new StringBuilder(String.valueOf(number));
		sb.reverse();
		return Integer.parseInt(sb.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(reverseInteger(n));
		in.close();
	}

}
