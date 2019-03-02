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
//		for-each循环不能修改数组，可以读出数组的每一个值
//		for (<类型><变量>:<数组>)
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
			System.out.println(x+"是第"+(loc+1)+"个");
		}
		else
		{
			System.out.println(x+"不在其中");
		}
	}

}
