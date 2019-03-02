package exception;

public class ArrayIndex {
	
	public static void f() {
		int[] a = new int[10];
		a[10] = 10;
		System.out.println("f");
	}
	
	public static void g() {
		f();
		System.out.println("g");
	}
	
	public static void h() {
		int i = 10;
		if (i < 100) {
			g();
		}
		System.out.println("h");
	}
	
	public static void k() {
		try {
			h();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("k");
//			System.err.println("An exception was thrown");
			throw e;
		}
	}
	public static void main(String[] args) {
		try {
			k();
			System.out.println("bye");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("CaughtAIOB");
//			System.out.println(e.getMessage());
//			System.out.println(e);
//			e.printStackTrace();
		}
		System.out.println("main");
	}

}
