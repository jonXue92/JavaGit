package hello;

import java.util.Scanner;

public class Factor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
//		int i = 1;
		int factor = 1;
//		while (i<=n){
//			factor *= i;
//			i++;
//		}
//		int 4-byte [-2^31,2^31-1]
		for (int i=1;i<=n;i++)
//		初始化；条件；单步动作
		{
			factor *= i;
		}
//		i=0;
		System.out.println(factor);
//		a *= b+6 == a = a*(b+6);
//		a / b * 6 == a / (b*6);
//		a = i++; == a = i;i=i+1; 
//		a = ++i; == i = i+1; a=i;
	}

}
