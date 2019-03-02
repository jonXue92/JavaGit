package notebook;

import java.util.List;
import java.util.ArrayList;

public class Notebook {
	private List<String> notes = new ArrayList<>();
	
	public void add(String s) {
		notes.add(s);
	}
	public void insert(String s, int index) {
		if (index < 0 || index > notes.size()) {
			return;
		}
		notes.add(index, s);
	}
	public int getSize() {
		return notes.size();
	}
	public String getNote(int index) {
		if (index < 0 || index >= notes.size()) {
			return null;
		}
		return notes.get(index);
	}
	public void removeNote(int index) {
		if (index < 0 || index >= notes.size()) {
			return;
		}
		notes.remove(index);
	}
	public String[] list() {
		String[] a = new String[notes.size()];
		notes.toArray(a);
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ia = new int[10];
		for (int i = 0; i < ia.length; i++) {
			ia[i] = i;
		}
		for (int k: ia) {
			k++;
		}
		for (int k: ia) {
			System.out.print(k+" ");
		}
		System.out.println();
		String[] sa = new String[10];
		for (int i = 0; i < sa.length; i++) {
			sa[i] = ""+i;
		}
		for (String s: sa) {
			s = "av";
		}
		for (String s: sa) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println(ia[0]);
		System.out.println(sa[0]);
		System.out.println(ia[0]+2);
		System.out.println(sa[0]+"2");
		System.out.println(sa[0].length());
		String s = null;
		System.out.println(s.length());
	}

}
