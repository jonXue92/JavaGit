package hello;

import java.util.Scanner;

public class Compare {

	public static void main(String[] args) {
		// ��ʼ��
//		System.out.println(5==5.0);
//		double a = 1.0;
//		double b = 0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1;
//		System.out.println("a="+a+";b="+b);
//		System.out.println(a==b);
//		System.out.println(Math.abs(a-b) < 1e-6);
		Scanner in = new Scanner(System.in);
		int balance = 0;
		//			����Ͷ�ҽ��
		while (true)
		{
			System.out.print("��Ͷ�ң�");
			int amount = in.nextInt();
			balance = balance + amount;
//			System.out.println(amount);
//			System.out.println(amount>=10);
			System.out.println("Ʊ�ۣ�10Ԫ");
//			����
			if (balance >= 10)
			{
				System.out.println("���㣺"+(balance-10)+"Ԫ.");
				balance = 0;
			}
			else
			{
				System.out.println("Your money is not enough!�벹"+(10-amount)+"Ԫ.");
			}
		}
//		����ע�ͣ�����ע��
//		int ak=47 /* 36 */,y=9;
	}

}
