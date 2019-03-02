package notebook;

import java.util.ArrayList;

public class TestOfArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        String a = new String();
	        a = "hello world!";
	        ArrayList<String> s = new ArrayList<String>();
	        s.add(a);
	        System.out.println(s.get(0));
	        a = "HELLO ARRAYLIST!";
	        System.out.println(s.get(0));
	        String b = new String();
	        b = "hello";
	        b = "world";
	        String c =new String();
	        String d =new String();
	        c = "ArrayList";
	        d = c;
	        c = "arraylist";
    }
}
