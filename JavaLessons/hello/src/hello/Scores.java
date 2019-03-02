package hello;

import java.util.Scanner;

public class Scores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] scores = {97,98};
		System.out.println(scores.length);
		for (int i=0;i<scores.length;i++)
		{
			System.out.print(scores[i]+" ");
		}
//		int[] a = new int[10];
//		a[0] = 5;
//		int[] b = a;
//		b[0] = 16;
//		int[] a = {1,2,3};
//		int[] b = {1,2,3};
//		System.out.println(a==b);
	}

}
