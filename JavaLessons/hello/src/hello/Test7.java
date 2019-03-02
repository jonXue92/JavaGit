package hello;

import java.util.Scanner;

public class Test7 {
	public static void defa(int n) {
		int i=2;
		while (i<n)
		{
			if (n%i==0)
			{
				System.out.print(i+"x");
				n /= i;
				break;
			}
			else
			{
				i++;
			}
		}
		if (n == i)
		{
			System.out.print(n);
		}
		else
		{
			defa(n);	
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.print(n+"=");
		defa(n);
	}

}
