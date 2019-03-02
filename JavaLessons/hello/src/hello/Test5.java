package hello;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);	
		int count = 0;
		int pow = 0;
		int coefficient = 0;
		int maxpower = 0;
		int maxpow = 0;
		int minpow=0;
		int[] power = new int[101];
		do 
		{
			pow = in.nextInt();
			coefficient = in.nextInt();
			power[pow] += coefficient;
			if (maxpower <= pow)
			{
				maxpower = pow;
			}
			if (pow == 0)
			{
				count += 1;
			}
		} while (count != 2);
		for (int i=maxpower;i>=0;i--)
		{
			if (power[i] != 0)
			{
				maxpow = i;
				break;
			}
		}
		for (int i=0;i<=maxpow;i++)
		{
			if (power[i] != 0)
			{
				minpow = i;
				break;
			}
		}
		for (int i=maxpow;i>=minpow;i--)
		{
			if (i==maxpow)
			{
				if (i==0)
				{
					System.out.print(power[i]);
				}
				else if (i==1)
				{
					if (power[i] > 0 && power[i] != 1 || power[i] < 0 && power[i] != -1)
					{
						System.out.print(power[i]+"x");
					}
					else if (power[i] == 1)
					{
						System.out.print("x");
					}
					else if (power[i] == -1)
					{
						System.out.print("-x");
					}
				}
				else if (i>1)
				{
					if (power[i] > 0 && power[i] != 1 || power[i] < 0 && power[i] != -1)
					{
						System.out.print(power[i]+"x"+i);
					}
					else if (power[i] == 1)
					{
						System.out.print("x"+i);
					}
					else if (power[i] == -1)
					{
						System.out.print("-x"+i);
					}
				}
			}
			else
			{
				if (power[i] > 0 && power[i] != 1)
				{
					if (i==0)
					{
						System.out.print("+"+power[i]);
					}
					else if (i==1)
					{
						System.out.print("+"+power[i]+"x");
					}
					else if (i>1)
					{
						System.out.print("+"+power[i]+"x"+i);
					}
				}
				else if (power[i] < 0 && power[i] != -1)
				{
					if (i==0)
					{
						System.out.print(power[i]);
					}
					else if (i==1)
					{
						System.out.print(power[i]+"x");
					}
					else if (i>1)
					{
						System.out.print(power[i]+"x"+i);
					}
				}
				else if (power[i] == 1)
				{
					if (i==0)
					{
						System.out.print("+1");
					}
					else if (i==1)
					{
						System.out.print("+x");
					}
					else if (i>1)
					{
						System.out.print("+x"+i);
					}
				}
				else if (power[i] == -1)
				{
					if (i==0)
					{
						System.out.print("-1");
					}
					else if (i==1)
					{
						System.out.print("-x");
					}
					else if (i>1)
					{
						System.out.print("-x"+i);
					}
				}
			}
		}
	}

}
