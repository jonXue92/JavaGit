package data;

import java.util.Collections;
import java.util.Scanner;

public class Selftest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		String sign = in.next();
		int n = 0;
		while (number >= 2*n*n - 1)
		{
			n++;
		} 
		n--;
		int yuxia = number - 2*n*n + 1;
//		��java���ظ�һ���ַ���n�εļ��ַ���
//		������String.format("%0" + n + "d", 0).replace("0",s);
//		��Σ�new String(new char[n]).replace("\0", s);
//		�Ͽ죺String.join("", Collections.nCopies(n, s));
		for (int i = n;i>=1;i--)
		{
			if (i<n)
			{
				System.out.print(String.join("", Collections.nCopies(n-i, " ")));
			}
			System.out.println(String.join("", Collections.nCopies(2*i-1, sign)));
		}
		for (int i = 2;i<=n;i++)
		{
			if (i<n)
			{
				System.out.print(String.join("", Collections.nCopies(n-i, " ")));
			}
			System.out.println(String.join("", Collections.nCopies(2*i-1, sign)));
		}
		System.out.println(yuxia);
		in.close();
	}

}
