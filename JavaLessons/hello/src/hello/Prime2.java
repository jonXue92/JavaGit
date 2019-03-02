package hello;

import java.util.Scanner;

public class Prime2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] primes = new int[100];
		primes[0] = 2;
		int count = 1;
		MAIN_LOOP:
		for (int x = 3;count < primes.length;x++)
		{
			for (int i=0;i<count;i++)
			{
				if (x % primes[i] == 0)
				{
					continue MAIN_LOOP;
				}
			}
			primes[count++] = x;
		}
		for (int k:primes)
		{
			System.out.print(k+" ");
		}
	}

}
