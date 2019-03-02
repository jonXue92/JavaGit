package display.led;

public class Display {
	private int value = 0;
	private int limit = 0;
	private static int step = 1;
	public static void f() {
//		value 
	}
	public Display(int limit) {
		this.limit = limit;
	}
	public boolean increase() {
		value++;
		if (value == limit) {
			value = 0;
			return true;
		}
		return false;
	}
	public int getValue() {
		return value;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Display d = new Display(24);
//		for (;;) {
//			d.increase();
//			System.out.println(d.getValue());
//		}
		Display d1 = new Display(10);
		d1.step = 5;
		System.out.println(d1.step+" ");
		Display d2 = new Display(20);
		System.out.println(d1.step+" "+d2.step);
		d1.increase();
		System.out.println(d1.getValue()+" "+d2.getValue());
		System.out.println(d1.step+" "+d2.step);
		d1.step = 2;
		System.out.println(d1.step+" "+d2.step);
		d2.step++;
		System.out.println(d1.step+" "+d2.step);
		Display.step = 4;
		System.out.println(d1.step+" "+d2.step);
//		Display.value;
//		increase();
		f();
		d1.f();
	}

}
