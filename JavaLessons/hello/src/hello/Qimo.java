package hello;

import java.util.Scanner;

public class Qimo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num=in.nextInt();
		if(num<0) {
			System.out.println(0);
		}else if(num==0) {
			System.out.println(32);
		}else {
			int i=0;
			while(num>=Math.pow(2, i)){
				i++;
			}
			System.out.println(32-i);
		}
		in.close();
	}

}
