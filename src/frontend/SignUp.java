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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up As An Admin:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 10, 152, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 47, 71, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(10, 69, 71, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Passwod again:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(10, 92, 106, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		usernameFiled = new JTextField();
		usernameFiled.setBounds(120, 44, 116, 19);
		getContentPane().add(usernameFiled);
		usernameFiled.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 66, 116, 19);
		getContentPane().add(passwordField);
		
		passwordFieldAgain = new JPasswordField();
		passwordFieldAgain.setBounds(120, 89, 116, 19);
		getContentPane().add(passwordFieldAgain);
		
		JButton btnNewButton = new JButton("Sign Up");
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
				//############################################################################
				//Insert
				String sqlp = "insert into admin values (" + id + ", '" + userName + "', '" + pswd1 + "');";
				if(canInsert == true) {
					dbm.CommandExecute(sqlp);
					noti.CustomNotification("Sikeres felvitel!", 1);
				}
				
				
			}
		});
		btnNewButton.setBounds(341, 232, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(246, 232, 85, 21);
		getContentPane().add(btnClose);

	}
	
	//############################################################################
	//Notification
	
	
	
	
}
