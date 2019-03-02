package hello;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s;
		s = in.next();
		while (!s.contains("."))
		{
			System.out.print(s.length()+" ");
			s = in.next();
		}
		if (s.length() != 1)
		{
			System.out.print((s.length()-1));
		}
	}

}
