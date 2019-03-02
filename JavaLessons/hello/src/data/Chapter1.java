package data;

import java.util.Scanner;

public class Chapter1 {
	public static void printn1(int n) {
		for (int i=0;i<n;i++)
		{
			System.out.println(i+1);
		}
	}
	public static void printn2(int n) {
		if (n>0)
		{
			printn2(n-1);
			System.out.println(n);
		}
	}
	public static double mulpowstupid(int n,double[] a,double x) {
		double p=a[0];
		for (int i=1;i<=n;i++)
		{
			p+=(a[i]*Math.pow(x, i));
		}
		return p;
	}
	public static double mulpow(int n,double[] a,double x) {
		double p=a[n];
		for (int i=n;i>0;i--)
		{
			p = a[i-1]+x*p;
		}
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		double[] a = new double[101];
		a[0]=0;
		for (int i=1;i<a.length;i++)
		{
			a[i]=(double)(1.0/i);
		}
		long starttime=System.nanoTime();
//		printn1(n);
//		printn2(n);
		System.out.println(mulpow(100,a,1.1));
		long endtime=System.nanoTime();
		System.out.println(endtime-starttime+"ns");
		
		starttime=System.nanoTime();
		System.out.println(mulpowstupid(100,a,1.1));
		endtime=System.nanoTime();
		System.out.println(endtime-starttime+"ns");
		in.close();
	}

}
