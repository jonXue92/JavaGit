package data;

import java.util.Scanner;

public class Selftest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		boolean[] isPrime = new boolean[N+1];
		int[] Prime = new int[N+1];
		for (int i = 0;i<isPrime.length;i++)
		{
			isPrime[i] = true;
		}
		for (int i = 2;i<isPrime.length;i++)
		{
			if (isPrime[i])
			{
				for (int k = 2;i*k<isPrime.length;k++)
				{
					isPrime[i*k]=false;
				}
			}
		}
		int j = 0;
		for (int i = 2;i<isPrime.length;i++)
		{
			if (isPrime[i])
			{
				Prime[j] = i;
				j++;
			}
		}
		int count=0;
		for (int i = 1;i<Prime.length;i++)
		{
			if (Prime[i]-Prime[i-1] == 2)
			{
				count+=1;
			}
			else if (Prime[i]-Prime[i-1] < 0)
			{
				break;
			}
		}
		System.out.println(count);
		in.close();
	}

}
