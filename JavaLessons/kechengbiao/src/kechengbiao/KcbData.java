package kechengbiao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class KcbData implements TableModel {

	private String[] week = {
		"Mon","Tue","Wed","Thu","Fri","Sat","Sun"
	};
	private String[][] data = new String[8][7];
	
	public KcbData() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = "";
			}
		}
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public String getColumnName(int arg0) {
		return week[arg0];
	}

	@Override
	public int getRowCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return data[arg0][arg1];
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		data[arg1][arg2] = (String)arg0;
	}

}
