package hello;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double sum = 0;
		int count = 0;
		count = in.nextInt();
//		<类型>[] <名字> = new <类型>[元素个数]
		if (count > 0)
		{
			int[] numbers = new int[count];
	//		元素个数可以是变量
	//		int k = numbers[-1];
	//		编译器不会检查你是否使用了越界的下标
//			可扩展性
			for (int i=0;i<numbers.length;i++)
			{
				numbers[i] = in.nextInt();
				sum += numbers[i];
			}
			double average = sum/count;
			for (int i=0;i<numbers.length;i++)
			{
				if(numbers[i] >= average)
				{
					System.out.println(numbers[i]);
				}
			}
		}
	}

}
