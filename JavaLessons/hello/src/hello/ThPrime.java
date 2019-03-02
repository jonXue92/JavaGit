package hello;

import java.util.Scanner;

public class ThPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int count=in.nextInt();
		int n = 2;
		int th = 0;
		while (true) 
		{
			boolean isPrime = true;
			for (int i=2;i<=Math.sqrt(n);i++)
			{
				if (n % i == 0)
				{
					isPrime = false;
					break;
				}
			}
			if (isPrime)
			{
				System.out.print(n+" ");
				th += 1;
				if (th == count)
				{
					break;
				}
			}
			n++;
		}
	}

}
