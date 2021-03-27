package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import backend.ServiceTM;
import backend.UserTM;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ServiceList extends JDialog {
	private JTable table;
	private ServiceTM stm;


	public ServiceList(JDialog f, ServiceTM setm) {
		super(f, "Szolgáltatások Listája", true);
		stm = setm;
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 516, 210);
		getContentPane().add(scrollPane);
		
		table = new JTable(stm);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.setBounds(217, 232, 85, 21);
		getContentPane().add(btnNewButton);

		TableColumn tc = null;
		for (int i = 0; i < 4; i++) {
			tc = table.getColumnModel().getColumn(i);
			if (i==0 || i == 1) tc.setPreferredWidth(30);
			else if (i==2) tc.setPreferredWidth(100);
			else {tc.setPreferredWidth(80);}
		}

		table.setAutoCreateRowSorter(true);
		TableRowSorter<UserTM> trs = (TableRowSorter<UserTM>)table.getRowSorter();
		trs.setSortable(0, false);

		Object stmt[] = {"Jel","Sid","Név","Ár"};
		stm = new ServiceTM(stmt, 0);
		
	}
}
