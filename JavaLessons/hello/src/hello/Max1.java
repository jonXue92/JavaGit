package hello;

import java.util.Scanner;

public class Max1 {
	public static double max(double a,double b) {
		double ret=0;
		if (a > b)
		{
			ret=a;
		}
		else
		{
			ret=b;
		}
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		System.out.println(max(a,b));
		System.out.println(max('1',2));
		System.out.println(max('1',(char)2));
		System.out.println(max('1','2'));
	}

}
