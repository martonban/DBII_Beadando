package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;

import backend.CheckMethods;
import backend.DBMethods;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFunction extends JDialog {
	
	private Notification noti = new Notification();
	private CheckMethods check = new CheckMethods();
	private static DBMethods dbm = new DBMethods();
	private JTextField tableField;
	private JTextField fieldField;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbm.Reg();
		dbm.Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFunction dialog = new DeleteFunction();
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
	public DeleteFunction() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete User:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 119, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name of the table");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 54, 129, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name of the field");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(160, 54, 119, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID Number (int)");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(307, 54, 119, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		tableField = new JTextField();
		tableField.setBounds(20, 77, 96, 19);
		getContentPane().add(tableField);
		tableField.setColumns(10);
		
		fieldField = new JTextField();
		fieldField.setBounds(170, 77, 96, 19);
		getContentPane().add(fieldField);
		fieldField.setColumns(10);
		
		idField = new JTextField();
		idField.setBounds(317, 77, 96, 19);
		getContentPane().add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canDelete = true; 
				String table = tableField.getText();
				String field = fieldField.getText();
				String strNum = idField.getText();
				int id = 0;
				
				if(check.isThatInt(strNum)) {
					id = Integer.parseInt(strNum);
				}else {
					noti.CustomNotification("Nem szám típusú az ID", 0);
				}
				
				dbm.deleteRecord(table, field, id);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 220, 85, 21);
		getContentPane().add(btnNewButton);

	}

}
