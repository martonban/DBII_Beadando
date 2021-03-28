package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import backend.DBMethods;
import backend.ServiceTM;
import backend.UserTM;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListServiceByPriceForm extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private Notification noti = new Notification();
	private ServiceTM stm;
	private static DBMethods dbm = new DBMethods();

	public ListServiceByPriceForm() {
		dbm.Reg();
		dbm.Connect();
		setBounds(100, 100, 350, 230);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Szolg\u00E1ltat\u00E1s list\u00E1z\u00E1sa \u00E1r alapj\u00E1n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 10, 291, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Minimum:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(39, 63, 77, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 87, 121, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 87, 121, 19);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Maximum:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(209, 63, 77, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Mehet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean a = true;
				String text = textField.getText();
				int minimum = 0;
				try {
					minimum = Integer.parseInt(text);
				}catch(NumberFormatException e1) {
					noti.CustomNotification("Nem átalakítható", 0);
				}
				String text2 = textField_1.getText();
				int maximum = 0;
				try {
					maximum = Integer.parseInt(text2);
				}catch(NumberFormatException e1) {
					noti.CustomNotification("Nem átalakítható", 0);
				}
				
				if(maximum < minimum) {
					noti.CustomNotification("Nem megfelflõ input!", 0);
					a = false;
				}
				
				
				if(a == true) {
					stm = dbm.ReadAllService(minimum, maximum);
					ServiceList sl = new ServiceList(ListServiceByPriceForm.this, stm);
					sl.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(119, 162, 85, 21);
		getContentPane().add(btnNewButton);
		Object stmt[] = {"Jel","Sid","Név","Ár"};
		stm = new ServiceTM(stmt, 10);
	}
}
