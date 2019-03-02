package data;

import java.util.Scanner;

public class MaxSubseqSum {
	public static void maxsubseqsum1(int[] a) {
		int i;
		int j;
		int k;
		int sum;
		int[] b = a;
		int maxsum=0;
		for (int l=0;l<a.length;l++)
		{
			maxsum+=a[l];
		}
		for (i=a.length-1;i>=1;i--)
		{
			for (j=0;j<=a.length-i;j++)
			{
				sum=0;
				for (k=0;k<i;k++)
				{
					sum+=a[j+k];
				}
				if (sum>maxsum)
				{
					maxsum=sum;
					b = new int[i];
					for (int m=0;m<i;m++)
					{
						b[m]=a[j+m];
					}
				}
			}
		}
		System.out.println(maxsum);
		for (int o=0;o<b.length;o++)
		{
			System.out.print(b[o]+" ");
		}
	}
	public static void maxsubseqsum2(int[] a) {
		int i;
		int j;
		int sum;
		int[] b=a;
		int maxsum=0;
		for (i=0;i<a.length;i++)
		{
			sum=0;
			for (j=i;j<a.length;j++)
			{
				sum+=a[j];
				if (sum>maxsum)
				{
					maxsum=sum;
					b = new int[j-i+1];
					for (int m=i;m<=j;m++)
					{
						b[m]=a[m];
					}
				}
			}
		}
		System.out.println(maxsum);
		for (int o=0;o<b.length;o++)
		{
			System.out.print(b[o]+" ");
		}
	}	
	public static int[] maxsubseqsum3(int[] a) {
		//分而治之，二分法
		int leftsum=0;
		int rightsum=0;
		int midleftsum=0;
		int midrightsum=0;
		int maxsum=0;
		int sum=0;
		int left=0;
		int right=0;
		if (a.length>1)
		{
			int[] b = new int[a.length/2];
			int[] c = new int[a.length-a.length/2];
			for (int i=0;i<b.length;i++)
			{
				b[i]=a[i];
			}
			for (int i=0;i<c.length;i++)
			{
				c[i]=a[i+a.length/2];
			}
			for (int i=a.length/2-1;i>=0;i--)
			{
				sum+=a[i];
				if (sum>midleftsum)
				{
					midleftsum=sum;
					left=a[i];
				}
			}
			sum=0;
			for (int i=a.length/2;i<a.length;i++)
			{
				sum+=a[i];
				if (sum>midrightsum)
				{
					midrightsum=sum;
					right=a[i];
				}
			}
			maxsum=midleftsum+midrightsum;
			leftsum=maxsubseqsum3(b)[0];
			rightsum=maxsubseqsum3(c)[0];
			if (leftsum>maxsum)
			{
				maxsum=leftsum;
			}
			if (rightsum>maxsum)
			{
				maxsum=rightsum;
			}
		}
		else
		{
			maxsum=a[0];
			left=a[0];
			right=a[0];
		}
		int[] result=new int[3];
		result[0]=maxsum;
		result[1]=left;
		result[2]=right;
		return result; 
	}
	public static void maxsubseqsum4(int[] a) {
		//在线处理伪码：
		int i;
		int begin=0;
		int end=0;
		int sum=0;
		int maxsum=0;
		int flag=-1;
		for (i=0;i<a.length;i++)
		{
			if (a[i]>=0)
			{
				flag=1;
			}
			sum+=a[i];
			if (sum>maxsum)
			{
				maxsum=sum;
				end=i;
			}
			else if (sum==maxsum && a[i]==0)
			{
				if (a[begin]!=0)
				{
					end=i;
				}
			}
			else if (sum < 0)
			{
				sum=0;
				if (i<=end)
				{
					begin=i+1;
					end=i+1;
				}
			}
		}
		if (flag==-1)
		{
		  begin=0;
		  end=a.length-1;
		}
		System.out.println(maxsum+" "+a[begin]+" "+a[end]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
//		int[] a = {-10,1,2,3,4,-23,3,7,-21};
//		int[] a = {-10,3,4,-5,7,-21};
//		int[] a = {-10,-5,23,-21};
//		int[] a = {-10,-5,-23,-21};
//		int[] a = {-23,3,7,0,0,-21};
		int[] a = {-10,0,0,-5,-21};
//		int[] a = {-10,0,0,3,7,-21};
//		int[] a = {0,1,2,3,5,0,-7};
//		System.out.println(maxsubseqsum3(a)[0]);
//		System.out.println(maxsubseqsum3(a)[1]+" "+maxsubseqsum3(a)[2]);
		maxsubseqsum4(a);
		in.close();
	}

}
