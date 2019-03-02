package hello;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number;
		int sum=0;
		int count=0;
//		int newnumber = in.nextInt();
//		while (newnumber != -1)
//		{
//			sum += newnumber;
//			count += 1;
//			newnumber = in.nextInt();
//		}
		do {
			number = in.nextInt();
			if (number != -1)
			{
				sum += number;
				count += 1;
			}
		} while (number != -1);
		if (count > 0)
		{
			System.out.println("Æ½¾ùÊı="+(double)sum/count);
		}
	}

}
