package hello;

import java.util.Scanner;

public class Fenjie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int newnumber = 0;
		do {
			int digit = number % 10;
			newnumber = newnumber*10 + digit; 
			number = number / 10;
		} while (number !=0 );
		System.out.println(newnumber);
	}

}
