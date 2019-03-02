package hello;

public class Factor1 {
	public static int factor(int i) {
		if (i==1)
		{
			return i;
		}
		return i*factor(i-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = factor(3);
		System.out.println(k);
	}

}
