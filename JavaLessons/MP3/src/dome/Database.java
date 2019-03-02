package dome;

import java.util.ArrayList;
import java.util.List;

public class Database {
	
	private List<Item> listItem = new ArrayList<>();
	public void add(Item item) {
		listItem.add(item);
	}

	public void list() {
		for (Item item : listItem) {
			item.print();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));
		db.add(new CD("def", "def", 8, 120, "......"));
		db.add(new DVD("xxx", "yyy", 60, "........."));
		db.add(new VideoGame("fff", 100, false, "............", 4));
		db.list();
//		CD cd = new CD("abc","abc",4,60,"...");
//		Item item = cd;
//		CD cd0 = (CD)item;
//		Item item1 = new Item();
//		CD cd1 = item1;
//		CD cd1 = (CD)item1;
	}
}
