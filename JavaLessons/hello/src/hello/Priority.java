package hello;

public class Priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 2;
		result = (result = result * 2) * 6 * (result = 3 + result);
		System.out.println(result);
//		==和!=的优先级比其他的低
		System.out.println(7>5 == 3>4);
//		System.out.println(a==b>false)
//		System.out.println((a==b)>false)
	}

}
