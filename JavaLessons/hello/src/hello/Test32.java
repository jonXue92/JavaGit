package hello;

import java.util.Scanner;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int result = 0;
		int weishu = 0;
		int jinzhi = 1;
		do {
			weishu += 1;
			if ((number % 10 - weishu) % 2 == 0)
			{
				result += jinzhi; 
			}
			jinzhi *= 2;
			number = number / 10;
		} while (number != 0);
		System.out.println(result);
	}

}
