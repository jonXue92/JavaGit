package data;

class Callme{
	synchronized void test() {
		System.out.println("�����Ƿ��ǣ�һ��һ���߳̽���һ��ʵ�����κ�ͬ������������߳̽����ܽ����ͬһʵ��������ͬ�����������Ǹ�ʵ���ķ�ͬ��������Ȼ�ܹ�������");
	}
	void nonsynCall(String msg) {
		System.out.println("["+msg+"]");
	}
	synchronized void synCall(String msg) {
		System.out.println("["+msg+"]");
	}
}

class Caller implements Runnable{
	String msg;
	Callme target;
	Thread t;
	Caller(Callme target,String msg){
		this.target=target;
		this.msg=msg;
		t=new Thread(this);
		t.start();
	}
	public void run() {
//		target.nonsynCall(msg);
		target.synCall(msg);
		target.test();
	}
}

public class SynTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callme target=new Callme();
		Caller ob1=new Caller(target,"Hello");
		Caller ob2=new Caller(target,"Synchronized");
		Caller ob3=new Caller(target,"World");
	}
}