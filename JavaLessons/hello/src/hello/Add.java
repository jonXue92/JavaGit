package hello;

import java.util.Scanner;

public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double sum = 0.0; 
		int sign = 1;
		for (int i = 1;i<=n;i++,sign=-sign)
//		for (int i = 1;i<=n;i++)
		{
			sum += sign*1.0/i;
//			sign = -sign;
//			sum += Math.pow(-1, i+1)*1.0/i;
		}
		System.out.println(sum);
		System.out.printf("%.2f",sum);
	}

}
