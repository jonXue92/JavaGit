package kechengbiao;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Kechengbiao {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTable table = new JTable(new KcbData());
		JScrollPane panel = new JScrollPane(table);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
