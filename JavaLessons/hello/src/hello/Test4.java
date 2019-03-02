package hello;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int count1=in.nextInt();
		int count2=in.nextInt();
		int n = 2;
		int th = 0;
		int sum = 0;
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
				th += 1;
				if (th >= count1 && th <= count2)
				{
					sum += n;
				}
				else if (th > count2)
				{
					break;
				}
			}
			n++;
		}
		System.out.println(sum);
	}

}
