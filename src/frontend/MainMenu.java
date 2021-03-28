package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;

import backend.DBMethods;
import backend.UserTM;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

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
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(null);
		
		JButton btnListUser = new JButton("Felhaszn\u00E1l\u00F3k");
		btnListUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				utm = dbm.ReadAllUsers();
				UserList ul = new UserList(MainMenu.this, utm);
				ul.setVisible(true);
			}
		});
		btnListUser.setBounds(205, 80, 112, 30);
		getContentPane().add(btnListUser);
		
		JButton btnUpdateUser = new JButton("Admin Frissit\u00E9s");
		btnUpdateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAdmin uu = new UpdateAdmin();
				uu.setVisible(true);
			}
		});
		btnUpdateUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdateUser.setBounds(399, 80, 112, 30);
		getContentPane().add(btnUpdateUser);
		
		JButton btnListByPrice = new JButton("Szolg\u00E1ltas");
		btnListByPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListServiceByPriceForm lsbp = new ListServiceByPriceForm();
				lsbp.setVisible(true);
			}
		});
		btnListByPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListByPrice.setBounds(205, 134, 112, 30);
		getContentPane().add(btnListByPrice);
		
		JLabel lblNewLabel = new JLabel("F\u0151men\u00FC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 10, 86, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hozz\u00E1ad\u00E1s");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 50, 86, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("List\u00E1z\u00E1s");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(205, 50, 86, 21);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnAddUser = new JButton("Felhaszn\u00E1l\u00F3");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUser adduser = new AddUser();
				adduser.setVisible(true);
			}
		});
		btnAddUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddUser.setBounds(10, 80, 112, 30);
		getContentPane().add(btnAddUser);
		
		JButton btnSzolgltas = new JButton("Szolg\u00E1lta\u00E1s");
		btnSzolgltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddService addservice = new AddService();
				addservice.setVisible(true);
			}
		});
		btnSzolgltas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSzolgltas.setBounds(10, 140, 112, 30);
		getContentPane().add(btnSzolgltas);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Egy\u00E9b");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(399, 50, 86, 21);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnAddUser_1_1_1 = new JButton("T\u00F6rl\u00E9s");
		btnAddUser_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteFunction delete = new DeleteFunction();
				delete.setVisible(true);
			}
		});
		btnAddUser_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddUser_1_1_1.setBounds(399, 134, 112, 30);
		getContentPane().add(btnAddUser_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("@martonban");
		lblNewLabel_2.setBounds(453, 240, 73, 13);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Bez\u00E1r\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(10, 232, 85, 21);
		getContentPane().add(btnNewButton);
		
		Object emptmn[] = {"Jel","Uid","Név","Jelszo","Elõfizetés","Kezdet", "Kártyaszám", "Érvényeség", "CVV", "Subed?"};
		utm = new UserTM(emptmn, 10);


	}
}
