package hello;

public class Swap {
	public static void swap(int a,int b) {
		int t;
		t = a;
		a = b;
		b = t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		int b = 6;
		swap(a,b);
		System.out.println(a+" "+b);
	}

}
