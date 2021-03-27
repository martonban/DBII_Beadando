package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateUser extends JDialog {
	private JTextField textField;
	private Notification noti;
	
	
	public UpdateUser() {
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
		
		JButton btnNewButton = new JButton("Find");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				int requestID = 0;
				try {
					requestID = Integer.parseInt(text);
				}catch(NumberFormatException e1) {
					noti.CustomNotification("Nem átalakítható", 0);
				}
				UpdateUserForm uuf = new UpdateUserForm(requestID);
				uuf.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 132, 75, 21);
		getContentPane().add(btnNewButton);
	}
}
