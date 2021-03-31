package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import backend.DBMethods;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JDialog {
	private JTextField usernameFiled;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldAgain;
	private static DBMethods dbm = new DBMethods();
	private Notification noti = new Notification(); 

	
	public SignUp() {
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Regisztr\u00E1ci\u00F3:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 10, 152, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Felhaszn\u00E1l\u00F3n\u00E9v:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 47, 106, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jelsz\u00F3:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(10, 69, 71, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Jelsz\u00F3 megint:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(10, 92, 106, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		usernameFiled = new JTextField();
		usernameFiled.setBounds(169, 41, 116, 19);
		getContentPane().add(usernameFiled);
		usernameFiled.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 63, 116, 19);
		getContentPane().add(passwordField);
		
		passwordFieldAgain = new JPasswordField();
		passwordFieldAgain.setBounds(169, 86, 116, 19);
		getContentPane().add(passwordFieldAgain);
		
		JButton btnNewButton = new JButton("Regisztr\u00E1ci\u00F3");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//############################################################################
				//Declaration
				boolean canInsert = true;
				String userName = usernameFiled.getText();
				String pswd1 = passwordField.getText();
				String pswd2 = passwordFieldAgain.getText();

				int id = dbm.makeNewID("admin", "id");
				
				//############################################################################
				//Validation
				if(pswd1.equals(pswd2) != true ) {
					canInsert = false;
					noti.CustomNotification("A jelszó nem egyezik meg!", 0);
				}
				
				if(userName.equals("") || pswd1.equals("") || pswd2.equals("")) {
					canInsert = false;
					noti.CustomNotification("Nincs bemnet!", 0);
				}
				
				//############################################################################
				//Insert
				String sqlp = "insert into admin values (" + id + ", '" + userName + "', '" + pswd1 + "', 30, 500000);";
				if(canInsert == true) {
					dbm.CommandExecute(sqlp);
					noti.CustomNotification("Sikeres felvitel!", 1);
				}
				
				
			}
		});
		
		btnNewButton.setBounds(320, 182, 106, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnClose = new JButton("Vissza");
		btnClose.setFont(new Font("Tahoma", Font.ITALIC, 9));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(225, 182, 85, 21);
		getContentPane().add(btnClose);

	}
	
}
