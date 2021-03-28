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
		
		JLabel lblNewLabel = new JLabel("Felhaszn\u00E1l\u00F3n\u00E9v:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 58, 116, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Jelsz\u00F3:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(10, 95, 86, 13);
		getContentPane().add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(151, 55, 116, 19);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Bel\u00E9p\u00E9s");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
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
		passwordField.setBounds(151, 89, 116, 19);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Bejelentkez\u00E9s");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 21, 155, 13);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnSignUp = new JButton("Regisztr\u00E1ci\u00F3");
		btnSignUp.setFont(new Font("Tahoma", Font.ITALIC, 9));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signup = new SignUp();
				signup.setVisible(true);
			}
		});
		btnSignUp.setBounds(341, 232, 85, 21);
		getContentPane().add(btnSignUp);
		
		JButton btnKilps = new JButton("Kil\u00E9p\u00E9s");
		btnKilps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKilps.setFont(new Font("Tahoma", Font.ITALIC, 9));
		btnKilps.setBounds(246, 232, 85, 21);
		getContentPane().add(btnKilps);

	}
}
