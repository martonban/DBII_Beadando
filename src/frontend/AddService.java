package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import backend.CheckMethods;
import backend.DBMethods;
import backend.Service;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddService extends JDialog {
	private JTextField nameField;
	private JTextField priceField;
	private static DBMethods dbm = new DBMethods();
	private Notification noti = new Notification();
	private CheckMethods check = new CheckMethods();
	private ArrayList<Service> arr = new ArrayList<Service>();
	
	/**
	 * Create the dialog.
	 */
	public AddService() {
		setBounds(100, 100, 413, 214);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Service: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 105, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00E9v:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 43, 61, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u00C1r:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(10, 66, 61, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		nameField = new JTextField();
		nameField.setBounds(63, 41, 116, 19);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(63, 66, 116, 19);
		getContentPane().add(priceField);
		
		JButton btnNewButton = new JButton("V\u00E9gleges\u00EDt\u00E9s");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbm.addSercive(arr);
				
			}
		});
		btnNewButton.setBounds(276, 149, 110, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Vissza");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		btnNewButton_1.setBounds(181, 149, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hozz\u00E1ad\u00E1s");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Declaration
				boolean canInsert = true;
				String username = nameField.getText();
				String strNum = priceField.getText();
				int price = 0;
				
				if(username.equals("")) {
					canInsert = false;
					noti.CustomNotification("Nics név megadva!", 0);
				}
				
				if(check.isThatInt(strNum)) {
					price = Integer.parseInt(strNum);
					if(price<0) {
						canInsert = false;
						noti.CustomNotification("Nem értelmezhetõ ár!", 0);
					}
				}else {
					canInsert = false;
					noti.CustomNotification("Nem szám típusú az ár!", 0);
				}
				
				int id = dbm.makeNewID("services", "sid");
				
				//Insert
				if(canInsert == true) {
					Service service = new Service(id, username, price);
					arr.add(service);
					service = null;
					noti.CustomNotification("Hozzáadva a tömbhöz", 1);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.ITALIC, 8));
		btnNewButton_2.setBounds(10, 105, 85, 21);
		getContentPane().add(btnNewButton_2);

	}
}
