package hello;

import java.util.Scanner;

public class Find {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] data = {3,2,5,6};
		int x = in.nextInt();
		int loc = -1;
		boolean found = false;
		for (int i=0;i<data.length;i++) 
		{
			if (x == data[i])
			{
				loc = i;
				break;
			}
		}
		for (int k:data) 
		{
			if (k == x)
			{
				found = true;
				break;
			}
		}
//		for-eachѭ�������޸����飬���Զ��������ÿһ��ֵ
//		for (<����><����>:<����>)
		for (int k:data)
		{
			k=0;
		}
		for (int k:data)
		{
			System.out.println(k);
		}
		if (loc > -1)
		{
			System.out.println(x+"�ǵ�"+(loc+1)+"��");
		}
		else
		{
			System.out.println(x+"��������");
		}
	}

}
