package hello;

import java.util.Scanner;

public class Test72 {
	public static boolean isWanshu(int n) {
		boolean isWanshu = false;
		double sum=0;
		for (int i=1;i<n/2+1;i++)
		{
			if (n%i == 0)
			{
				sum+=i;
			}
		}
		if (sum==n)
		{
			isWanshu=true;
		}
		return isWanshu;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int min=in.nextInt();
		int max=in.nextInt();
		boolean first=true;
		for (int i=min;i<=max;i++)
		{
			if (isWanshu(i))
			{
				if(first==true)
				{
					System.out.print(i);
					first = false;
				}
				else
				{
					System.out.print(" "+i);
				}
			}
		}
	}

}
