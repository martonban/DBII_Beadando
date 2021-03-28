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
import javax.swing.JPasswordField;

public class SignIn extends JDialog {
	private JTextField usernameField;
	private static DBMethods dbm = new DBMethods(); 
	private JPasswordField passwordField;
	private Notification noti = new Notification();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbm.Reg();
		dbm.Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn dialog = new SignIn();
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
	public SignIn() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 58, 86, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(10, 95, 86, 13);
		getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(113, 56, 116, 19);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = usernameField.getText();
				String pswd = passwordField.getText();
				int succses = dbm.signIn(username, pswd);
				if(succses == 1) {
					System.out.println("Sikeres Bejentekezés");
					MainMenu mainmenu = new MainMenu();
					mainmenu.setVisible(true);
					dispose();
				}else {
					noti.CustomNotification("Sikertelen Bejelentkezés", succses);
				}
				
			}
		});
		btnNewButton.setBounds(10, 156, 85, 21);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 90, 116, 19);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Sing In:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 21, 86, 13);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
			}
		});
		btnSignUp.setBounds(341, 232, 85, 21);
		getContentPane().add(btnSignUp);

	}
}
