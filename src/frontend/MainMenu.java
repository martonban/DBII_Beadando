package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;

import backend.DBMethods;
import backend.UserTM;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MainMenu extends JDialog {
	static DBMethods dbm = new DBMethods();
	private UserTM utm;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu dialog = new MainMenu();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MainMenu() {
		dbm.Reg();
		dbm.Connect();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnListUser = new JButton("List Users");
		btnListUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utm = dbm.ReadAllUsers();
				UserList ul = new UserList(MainMenu.this, utm);
				ul.setVisible(true);
			}
		});
		btnListUser.setBounds(10, 96, 112, 30);
		getContentPane().add(btnListUser);
		
		JButton btnUpdateUser = new JButton("Update User");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUser uu = new UpdateUser();
				uu.setVisible(true);
			}
		});
		btnUpdateUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdateUser.setBounds(10, 142, 112, 30);
		getContentPane().add(btnUpdateUser);
		
		Object emptmn[] = {"Jel","Uid","Név","Jelszo","Elõfizetés","Kezdet", "Kártyaszám", "Érvényeség", "CVV", "Subed?"};
		utm = new UserTM(emptmn, 10);


	}

}
