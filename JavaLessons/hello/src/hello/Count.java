package hello;

import java.util.Scanner;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
//		While
//		while (count>0)
//		{
//			System.out.println(count);
//			count = count -1;
//		}
//		System.out.println(count);
//		System.out.println("·¢Éä£¡");
//		Do While
		do
		{
			System.out.println(count);
			count = count -1;
		} while (count>0);
		System.out.println(count);
		System.out.println("·¢Éä£¡");
	}

}
