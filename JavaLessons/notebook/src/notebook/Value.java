package notebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Value {
	private int i;
	public void set(int i) {this.i = i;}
	public int get() {return i;}
	public String toString() { return ""+i;	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> b = new ArrayList<>();
		b.add("1");
		b.add("2");
		b.add("2");
		for (String s : b) {
			System.out.println(s);
		}
		System.out.println(b);
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(2);
		for (Integer k : s) {
			System.out.println(k);
		}
		System.out.println(s);
		Value[] a = new Value[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Value();
			a[i].set(i);
		}
		for (Value v: a) {
			System.out.print(v.get()+" ");
			v.set(0);
		}
		System.out.println();
		for (Value v: a) {
			System.out.print(v+" ");
//			System.out.print(v.get()+" ");
		}
	}

}
