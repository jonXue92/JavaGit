package test;

public class Person {
	public static void main(String[] args) {
		Person p1 = new Student(); 
		Person p2 = new PhDStudent();
//		PhDStudent phd1 = new Student();
//		Teacher t1 = new Person();
		Student s1 = new PhDStudent();
//		s1 = p1;
//		s1 = p2;
		p1 = s1;
//		t1 = s1;
//		s1 = phd1;//�Ϸ�
//		phd1 = s1;
	}
}
