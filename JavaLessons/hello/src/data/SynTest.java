package data;

public class SynTest {
	//非同步
	static void method(Thread thread) {
		System.out.println("begin "+thread.getName());
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("end "+thread.getName());
	}
	//同步方式一：同步函数，被同步关键字修饰的函数就是同步函数。
	synchronized static void method1(Thread thread) {//这个方法是同步的方法，每次只有一个线程可以进来
		System.out.println("begin "+thread.getName());
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}System.out.println("end "+thread.getName());
	}
	//同步方式二：同步代码块，被同步关键字封装的代码就是同步代码块
	static void method2(Thread thread) {
		synchronized(SynTest.class) {
			System.out.println("begin "+thread.getName());
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("end "+thread.getName());
		}
	}
	//同步方式三：使用同步对象锁
	private static Object _lock1=new Object();
//	private static byte _lock2[]= {};//锁的对象越小越好
	static void method3(Thread thread) {
		synchronized(_lock1) {
			System.out.println("begin "+thread.getName());
			try {
				Thread.sleep(2000);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			System.out.println("end "+thread.getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//启动3个线程，这里用了匿名类
		for (int i=0;i<3;i++) {
			new Thread() {
				public void run() {
//					method(this);
//					method1(this);
//					method2(this);
					method3(this);
				}
			}.start();
		}
	}

}
