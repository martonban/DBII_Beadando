package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import backend.UserTM;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserList extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private UserTM utm;


	public UserList(JDialog f, UserTM ustm) {
		super(f, "Felhasználók Listája", true);
		utm = ustm;
		setBounds(100, 100, 850, 300);
		getContentPane().setLayout(null);
		
		JButton btnBezaras = new JButton("Vissza");
		btnBezaras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
			}
		});
		btnBezaras.setBounds(378, 232, 85, 21);
		getContentPane().add(btnBezaras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 816, 215);
		getContentPane().add(scrollPane);
		
		table = new JTable(utm);
		scrollPane.setViewportView(table);
		
		TableColumn tc = null;
		for (int i = 0; i < 10; i++) {
			tc = table.getColumnModel().getColumn(i);
			if (i==1 || i==4 || i==7) tc.setPreferredWidth(30);
			else if (i==0 || i==8 || i==9) tc.setPreferredWidth(20);
			else if (i==2 || i==3 || i==5) tc.setPreferredWidth(100);
			else {tc.setPreferredWidth(160);}
		}

		table.setAutoCreateRowSorter(true);
		TableRowSorter<UserTM> trs = (TableRowSorter<UserTM>)table.getRowSorter();
		trs.setSortable(0, false);

		Object emptmn[] = {"Jel","Uid","Név","Jelszo","Elõfizetés","Kezdet", "Kártyaszám", "Érvényeség", "CVV", "Subed?"};
		utm = new UserTM(emptmn, 10);
	}
}
