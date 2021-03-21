package frontend;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import backend.CheckMethods;
import backend.DBMethods;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddService extends JDialog {
	private JTextField nameField;
	private JTextField priceField;
	private static DBMethods dbm = new DBMethods();
	private Notification noti = new Notification();
	private CheckMethods check = new CheckMethods();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbm.Reg();
		dbm.Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddService dialog = new AddService();
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
	public AddService() {
		setBounds(100, 100, 450, 300);
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
		
		JButton btnNewButton = new JButton("Besz\u00FAr\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
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
					String sqlp = "insert into services values (" + id + ", '" + username + "', " + price + ");";
					dbm.CommandExecute(sqlp);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(341, 232, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Kil\u00E9p\u00E9s");
		btnNewButton_1.setBounds(247, 232, 85, 21);
		getContentPane().add(btnNewButton_1);

	}

}
