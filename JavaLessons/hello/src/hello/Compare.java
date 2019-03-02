package hello;

import java.util.Scanner;

public class Compare {

	public static void main(String[] args) {
		// 初始化
//		System.out.println(5==5.0);
//		double a = 1.0;
//		double b = 0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1;
//		System.out.println("a="+a+";b="+b);
//		System.out.println(a==b);
//		System.out.println(Math.abs(a-b) < 1e-6);
		Scanner in = new Scanner(System.in);
		int balance = 0;
		//			读入投币金额
		while (true)
		{
			System.out.print("请投币：");
			int amount = in.nextInt();
			balance = balance + amount;
//			System.out.println(amount);
//			System.out.println(amount>=10);
			System.out.println("票价：10元");
//			找零
			if (balance >= 10)
			{
				System.out.println("找零："+(balance-10)+"元.");
				balance = 0;
			}
			else
			{
				System.out.println("Your money is not enough!请补"+(10-amount)+"元.");
			}
		}
//		行内注释，多行注释
//		int ak=47 /* 36 */,y=9;
	}

}
