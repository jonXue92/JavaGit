package lecture2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
////		int num=10000000000000;//-2^31 ~ 2^31 - 1
////		long bigNum=10000000000000;
//		long bigNum=10000000000000L;//-2^63 ~ 2^63 - 1
////		float floatNum=3.2;
//		float floatNum=3.2f;
//		double doubleNum=3.2f;//3.2
//		double doubleNum1=3.2;
//		float floatNum1=3;//3.0f
//		double doubleNum2=floatNum;
////		floatNum=doubleNum;
//		floatNum1=(float)doubleNum;
//		int num='a';
//		System.out.println(num);
//		char c=(char)10;
//		System.out.println(c);
//		System.out.println(10);
//		float result=3/2;//1->1.0f
//		float floatResult=3.0f/2;//3.0f/2.0f=1.5f
//		float floatResult1=3/2.0f;//3.0f/2.0f=1.5f
//		Scanner in = new Scanner(System.in);
//		int year=in.nextInt();
//		boolean isLeapYear=year % 4 == 0 && year % 100 !=0 || year % 400 == 0;
//		System.out.println(isLeapYear);
//		int age=50;
//		boolean isMale=true;
//		boolean isOldMan=isMale && age>60;
//		int num1=5;
//		float floatNum2=3.0f;
//		boolean orTrue= num==5 || floatNum2>4.5f;
//		boolean andTrue= num>8 || floatNum2>4.5f;
//		char ch='\'';//单引号表示字符
//		char ch1='\\';
//		int chNum='\n';
//		System.out.println(chNum);
//		System.out.println((int)'字');
//		char preChar='a';
//		char nextChar=(char)(preChar+1);
//		System.out.println(nextChar);
//		char lowerChar='a';
//		char upperChar=(char)(lowerChar-'a'+'A');
//		char upperChar2=Character.toUpperCase(lowerChar);
		int[][] matrix= new int[][] {
			{1,4,7},
			{2,15,13},
			{6,8,12}
		};
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
