package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
//        System.out.println("echo:" + in.nextLine());
        System.out.println(2+3+"=2+3="+(2+3));
        final int amount = 100;
        int price=0;
        System.out.print("please input how much you paid:");
        price = in.nextInt();
//        System.out.println("100-"+in.nextInt()+"="+(100-in.nextInt()));
        System.out.println(amount+"-"+price+"="+(amount-price));
	}

}
