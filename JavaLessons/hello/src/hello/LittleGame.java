package hello;

import java.util.Scanner;

public class LittleGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int input;
		int count = 0;
		int number = (int)(Math.random()*100+1);// [0,1) --> [1,100]
		do	{
			input = in.nextInt();
			if (input > number)
			{
				System.out.println("The input is bigger");
			}
			else
			{
				System.out.println("The input is smaller");
			}
			count += 1;
		} while (input != number);
		System.out.println("You are right!You guess "+count+" times!");
	}

}
