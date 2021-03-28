package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import backend.DBMethods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateAdmin extends JDialog {
	private JTextField textField;
	private Notification noti;
	private static DBMethods dbm = new DBMethods();	
	
	public UpdateAdmin() {
		dbm.Reg();
		dbm.Connect();
		setBounds(100, 100, 250, 200);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 45, 13);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 33, 96, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Keres\u00E9s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				int requestID = 0;
				try {
					requestID = Integer.parseInt(text);
				}catch(NumberFormatException e1) {
					noti.CustomNotification("Nem átalakítható vagy nics megadva semmi", 0);
				}
				
				//LUSTA LÉTEZÉS ELLENÖRZÉS :D
				try {
					String name = dbm.getAdminNameWithID(requestID);
					if(name.equals("")) {
						System.out.println("Csak hogy ne legyen üres a true ág");
					}else {
						UpdateAdminForm uuf = new UpdateAdminForm(requestID);
						uuf.setVisible(true);
						dispose();
					}
				}catch(NullPointerException e2){
					noti.CustomNotification("Nem létezõ felhasználó", 0);
				}
			}
		});
		btnNewButton.setBounds(10, 132, 83, 21);
		getContentPane().add(btnNewButton);
	}
}
