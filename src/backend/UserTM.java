package backend;

import javax.swing.table.DefaultTableModel;

public class UserTM extends DefaultTableModel {
	
	public UserTM (Object fildNames[], int rows){
		super(fildNames, rows);
	}
		
	public boolean isCellEditable(int row, int col) {
		if(col == 0) {return true;}
		return false;
	}
	
	public Class<?> getColumnClass(int index){
		if (index == 0) return(Boolean.class);
		else if (index == 1 || index == 4 || index == 8 || index == 9) return(Integer.class);
		return(String.class);
	}

}
