package hello;

import java.util.Scanner;

public class Cq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int amount = in.nextInt();
		OUT:
		for (int twenty = 0;twenty <= amount/20;twenty++)
		{
			for (int ten = 0;ten <= amount/10 - twenty*2;ten++)
			{
				for (int five = 0;five <= amount/5 - twenty*4 - ten*2;five++)
				{
					int one = amount-twenty*20-ten*10-five*5;
					System.out.println(twenty+"张20元，"+ten+"张10元，"+five+"张5元，"+one+"张1元-->"+amount+"元");
					break OUT;
				}
			}
		}
	}

}
