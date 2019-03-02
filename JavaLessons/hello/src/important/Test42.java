package important;

import java.util.Scanner;

public class Test42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int jiecheng = 0;
//		使用for循环也可以操作，不用对0进行特殊处理；注意--jiecheng的用法
		if (number == 0)
		{
			System.out.print("ling");
		}
		if (number < 0)
		{
			System.out.print("fu ");
			number = -number;
		}
		int on = number;
		while (on > 0 ) {
			on = on / 10;
			jiecheng += 1;
		} 
		while (jiecheng != 0)
		{
			int j;
			j = number / (int)Math.pow(10, --jiecheng);
			switch (j) {
			case 1:
				System.out.print("yi");
				break;
			case 2:
				System.out.print("er");
				break;
			case 3:
				System.out.print("san");
				break;
			case 4:
				System.out.print("si");
				break;
			case 5:
				System.out.print("wu");
				break;
			case 6:
				System.out.print("liu");
				break;
			case 7:
				System.out.print("qi");
				break;
			case 8:
				System.out.print("ba");
				break;
			case 9:
				System.out.print("jiu");
				break;
			case 0:
				System.out.print("ling");
				break;
			}
			if (jiecheng > 0)
			{
			System.out.print(" ");
			}
			number %=  (int)Math.pow(10,jiecheng);
		} 
	}

}
