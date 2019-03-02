package clock;

import display.led.Display;

public class Clock {
	private Display minute = new Display(60);
	private Display hour = new Display(24);
	
	public void start() {
		while (true) {
			if (minute.increase()) {
				hour.increase();
			}
			System.out.printf("%02d:%02d\n", hour.getValue(), minute.getValue());
		}
	}
	public String tostring() {
		return String.format("%02d", hour.getValue())+":"+String.format("%02d", minute.getValue());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock clock = new Clock();
//		clock.start();
		System.out.println(clock.tostring());
	}
}
