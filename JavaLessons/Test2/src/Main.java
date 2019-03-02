
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner in = new java.util.Scanner(System.in);
		Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
		clock.tick();
		System.out.println(clock);
		in.close();
	}
}
class Display {
	private int limit = 0;
	private int value = 0;
	public Display(int limit) {
		this.limit = limit;
	}
	public boolean increase() {
		this.value++;
		if (this.value == this.limit) {
			this.value = 0;
			return true;
		}
		return false;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
class Clock {
	private Display second = new Display(60);
	private Display minute = new Display(60);
	private Display hour = new Display(24);
	public Clock(int hour, int minute, int second) {
		this.hour.setValue(hour);
		this.minute.setValue(minute);
		this.second.setValue(second);
	}
	public void tick() {
		if(second.increase()) {
			if(minute.increase()) {
				hour.increase();
			}
		}
	}
	public String toString() {
		return String.format("%02d", hour.getValue())+":"+String.format("%02d", minute.getValue())+":"+String.format("%02d", second.getValue());
	}
}