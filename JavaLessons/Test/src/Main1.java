
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = "Hellp";
		s3 = s3.replace('p', 'o');
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
	}

}
