package hello;

import java.util.Scanner;

public class Countnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] count = new int[10];
		int x;
		x = in.nextInt();
		while (x != -1)
		{
			if (x>=0 && x<=9) 
			{
				count[x] ++;
			}
			x = in.nextInt();
		}
		for (int i=0;i<count.length;i++)
		{
			System.out.println(i+":"+count[i]);
		}
	}

}
