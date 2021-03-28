package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.CheckMethods;
import backend.DBMethods;
import javax.swing.JPasswordField;

public class UpdateAdminForm extends JDialog {
	
	private static CheckMethods check = new CheckMethods();
	private static DBMethods dbm = new DBMethods();
	private Notification noti = new Notification();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public UpdateAdminForm(int id) {
		dbm.Reg();
		dbm.Connect();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin neve");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 10, 153, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel ChangeName = new JLabel("New label");
		ChangeName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ChangeName.setBounds(10, 39, 153, 21);
		getContentPane().add(ChangeName);

		ChangeName.setText(dbm.getAdminNameWithID(id));

		passwordField = new JPasswordField();
		passwordField.setBounds(10, 88, 220, 19);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Jelsz\u00F3:");
		lblNewLabel_1.setBounds(10, 70, 81, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jelsz\u00F3 \u00DAjra:");
		lblNewLabel_1_1.setBounds(10, 130, 109, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(10, 148, 220, 19);
		getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("Friss\u00EDt\u00E9s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passs1 = passwordField.getText(); 
				String passs2 = passwordField_1.getText();
				if(passs1.equals(passs2) ) {
					String sqlp = "update admin set pass = '"+passs1+"' where id = "+id;
					dbm.CommandExecute(sqlp);
					noti.CustomNotification("Sikeres változtatás", 1);
				}
				else {
					noti.CustomNotification("A jelszavak nem egyeznek meg", 0);
				}
			}
		});
		btnNewButton.setBounds(341, 232, 85, 21);
		getContentPane().add(btnNewButton);
		
	}
}