package hello;

import java.util.Scanner;

public class Weishu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int weishu = 0;
//		错误的做法，对于0的特殊处理;
//		while ( number != 0 )
//		{
//			number = number/10;
//			weishu += 1;
//			System.out.println("number="+number+";weishu="+weishu);
//		}
		do
		{
			number = number/10;
			weishu += 1;
//			System.out.println("number="+number+";weishu="+weishu);
		} while ( number != 0 );
		System.out.println(weishu);
	}

}
