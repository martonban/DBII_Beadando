package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.setBounds(323, 232, 103, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 23, 85, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblJelsz = new JLabel("Jelsz\u00F3:");
		lblJelsz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJelsz.setBounds(10, 46, 85, 13);
		contentPane.add(lblJelsz);
		
		JLabel lblSzolgltatsId = new JLabel("Szolg\u00E1ltat\u00E1s ID");
		lblSzolgltatsId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSzolgltatsId.setBounds(10, 69, 103, 13);
		contentPane.add(lblSzolgltatsId);
		
		JLabel lblKrtyaSzm = new JLabel("K\u00E1rtya Sz\u00E1m:");
		lblKrtyaSzm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm.setBounds(10, 92, 103, 13);
		contentPane.add(lblKrtyaSzm);
		
		JLabel lblKrtyaSzm_1 = new JLabel("- ");
		lblKrtyaSzm_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1.setBounds(52, 119, 15, 13);
		contentPane.add(lblKrtyaSzm_1);
		
		textField = new JTextField();
		textField.setBounds(10, 117, 32, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(62, 117, 32, 19);
		contentPane.add(textField_1);
		
		JLabel lblKrtyaSzm_1_1 = new JLabel("- ");
		lblKrtyaSzm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1_1.setBounds(105, 120, 15, 13);
		contentPane.add(lblKrtyaSzm_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 117, 32, 19);
		contentPane.add(textField_2);
		
		JLabel lblKrtyaSzm_1_1_1 = new JLabel("- ");
		lblKrtyaSzm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1_1_1.setBounds(162, 119, 15, 13);
		contentPane.add(lblKrtyaSzm_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(172, 117, 32, 19);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 167, 29, 21);
		contentPane.add(comboBox);
		
		JLabel lblKrtyaSzm_2 = new JLabel("K\u00E1rtya Sz\u00E1m:");
		lblKrtyaSzm_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_2.setBounds(10, 146, 103, 13);
		contentPane.add(lblKrtyaSzm_2);
		
		JLabel lblKrtyaSzm_1_2 = new JLabel("/");
		lblKrtyaSzm_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1_2.setBounds(59, 170, 15, 13);
		contentPane.add(lblKrtyaSzm_1_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(84, 167, 29, 21);
		contentPane.add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 21, 175, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(120, 44, 175, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(120, 67, 60, 19);
		contentPane.add(textField_6);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCvv.setBounds(10, 211, 32, 13);
		contentPane.add(lblCvv);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(52, 209, 32, 19);
		contentPane.add(textField_7);
	}
}
