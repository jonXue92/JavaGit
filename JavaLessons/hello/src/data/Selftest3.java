package data;

import java.util.Scanner;

public class Selftest3 {
	public static void reverse(int a[],int i,int j) {  //����
		int t;
		while (i<j)
		{
			t=a[i];
			a[i]=a[j];
			a[j]=t;
			i++;j--;
		}
	}
	public static void adjust(int a[],int m) {  //����λ
		reverse(a,0,a.length-1); //ȫ������
		reverse(a,0,m-1); //����ǰm����
		reverse(a,m,a.length-1); //�����a.length-m����
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int i=0;i<n;i++)
		{
			a[i]=in.nextInt();
		}
		if(m>n)
		{
			m=m%n;
		}
		adjust(a,m);
		System.out.print(a[0]);
		for (int k=1;k<a.length;k++)
		{
			System.out.print(" "+a[k]);
		}
		in.close();
	}

}
