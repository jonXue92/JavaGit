package data;

import java.util.Arrays;
import java.util.Scanner;

public class Exchangevalue {
//Java�Ǵ�ֵ���õģ�����������C��������дһ��swap�����������޷����������������ֵ�ģ���Ϊ��
//���������������ֵ�ȷ��swap���������ڲ�ʵ���˽����������뿪�����������Ļ�����û�иı�
	public static void swap(int a,int b) {
		int temp=a;
		a=b;
		b=temp;
		System.out.println("a:"+a+"  ,  b:"+b);
	}
	public static void exchange(int a,int b) {
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a:"+a+"  ,  b:"+b);
	}
	public static void swap_arr(int[] array) {
		int temp=array[0];
		array[0]=array[array.length-1];
		array[array.length-1]=temp;
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int value1=in.nextInt();
		int value2=in.nextInt();
		System.out.println("value1:"+value1+"  ,  value2:"+value2);
		swap(value1,value2);
		System.out.println("value1:"+value1+"  ,  value2:"+value2);
		exchange(value1,value2);
		System.out.println("value1:"+value1+"  ,  value2:"+value2);
//		value1=value1+value2;
//		value2=value1-value2;
//		value1=value1-value2;
		value1=value1^value2;
		value2=value1^value2;
		value1=value2^value1;
		System.out.println("value1:"+value1+"  ,  value2:"+value2);
		int[] a= {1,2,3,4};
		swap_arr(a);
		System.out.println(Arrays.toString(a));
		in.close();
	}

}
