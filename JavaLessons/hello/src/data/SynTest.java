package data;

public class SynTest {
	//��ͬ��
	static void method(Thread thread) {
		System.out.println("begin "+thread.getName());
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("end "+thread.getName());
	}
	//ͬ����ʽһ��ͬ����������ͬ���ؼ������εĺ�������ͬ��������
	synchronized static void method1(Thread thread) {//���������ͬ���ķ�����ÿ��ֻ��һ���߳̿��Խ���
		System.out.println("begin "+thread.getName());
		try {
			Thread.sleep(2000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}System.out.println("end "+thread.getName());
	}
	//ͬ����ʽ����ͬ������飬��ͬ���ؼ��ַ�װ�Ĵ������ͬ�������
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
	//ͬ����ʽ����ʹ��ͬ��������
	private static Object _lock1=new Object();
//	private static byte _lock2[]= {};//���Ķ���ԽСԽ��
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
		//����3���̣߳���������������
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
