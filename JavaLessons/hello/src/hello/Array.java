package hello;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double sum = 0;
		int count = 0;
		count = in.nextInt();
//		<����>[] <����> = new <����>[Ԫ�ظ���]
		if (count > 0)
		{
			int[] numbers = new int[count];
	//		Ԫ�ظ��������Ǳ���
	//		int k = numbers[-1];
	//		���������������Ƿ�ʹ����Խ����±�
//			����չ��
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
