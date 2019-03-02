package lecture1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=10;
		int num1=1;
		//异或的方法模拟加减运算
		int n=num^num1;
		int n1=(num&num1) << 1;
		System.out.println(num+num1);
		System.out.println(n);
		System.out.println(n1);
		System.out.println(-10/3);//舍掉小数位
		System.out.println(-10%3);
		char ch=5;
		System.out.println(ch);
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s4);
	}
}
