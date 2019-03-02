package data;

import java.util.Arrays;
import java.util.Scanner;

public class Exchangevalue {
//Java是传值调用的，就像类似于C语言那样写一个swap（）函数是无法交换传入的两个数值的，因为，
//传进来的两个数字的确在swap（）函数内部实现了交换，但是离开这个函数整体的话还是没有改变
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
