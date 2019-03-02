package hello;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		for (int n=2; n <= 100;n++)
		{
			boolean isPrime = true;
//			! > && > ||
			if (n==1)
			{
				System.out.println("The input doesn't apply for this judgement!");
			}
			else
			{
				for (int i = 2; i <= Math.sqrt(n) ; i++)
				{
					if (n % i == 0)
					{
						isPrime = false;
//						System.out.println(n+"²»ÊÇËØÊý");
						break;
					}
				}
				if (isPrime)
				{
					System.out.print(n+" ");
				}
			}
		}
	}

}
