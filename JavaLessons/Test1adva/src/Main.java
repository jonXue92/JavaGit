
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}

}

class Fraction {
	private int a;
	private int b;
	public Fraction(int a,int b)
	{
		this.a=a;
		this.b=b;
		simp();
	}
	private void simp() {
		int gcd = gcd(a,b);
		if (gcd != 1) {
			a = a/gcd;
			b = b/gcd;
		}
	}
	private int gcd(int a, int b) {
		while (b!=0)
		{
			int t=a%b;
			a=b;
			b=t;
		}
		return a;
	}
	public double todouble()
	{
		return ((double)a)/b;
	}
	public Fraction plus(Fraction r)
	{
		int aa=a*r.b+b*r.a;
		int bb=b*r.b;
		return new Fraction(aa,bb);
	}
	public Fraction multiply(Fraction r)
	{
		return new Fraction(a*r.a,b*r.b);
	}
	public void print()
	{
		if (a == 1 && b == 1) {
			System.out.println(1);
		}
		else {
			System.out.println(a+"/"+b);
		}
	}
}


