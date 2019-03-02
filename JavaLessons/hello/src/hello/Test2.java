package hello;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int bjt;
		int utc;
		bjt = in.nextInt();
		int hb = bjt/100;
		int m = bjt%100;
		int hu;
		if (hb >= 8)
		{
			hu = hb - 8;
		}
		else
		{
			hu = hb + 16;
		}
		utc = hu * 100 + m;
		System.out.println(utc);
	}

}
