package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.CheckMethods;
import backend.DBMethods;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {
	
	
	private static CheckMethods check = new CheckMethods();
	private static DBMethods dbm = new DBMethods(); 
	

	private JPanel contentPane;
	private JTextField cardNumberPart1Field;
	private JTextField cardNumberPart2Field;
	private JTextField cardNumberPart3Field;
	private JTextField cardNumberPart4Field;
	private JTextField usernameTextField;
	private JTextField pswdField;
	private JTextField serviceField;
	private JTextField cvvField;
	private JTextField validPartOne;
	private JTextField validPartTwo;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbm.Reg();
		dbm.Connect();
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean canInsert = true;
				String username = usernameTextField.getText();
				String pswd = pswdField.getText();
				
				//############################################################################
				//Service ID check
				String serviceID = serviceField.getText();
				int sID = 0;
				if(check.isThatInt(serviceID)) {
					ArrayList<Integer> ids = new ArrayList<Integer>();
					ids = dbm.serviceID();
					sID = Integer.parseInt(serviceID);
					if(check.exsitInArrayList(ids,sID)) {
						System.out.println("Cool");
					}else {
						notExsitingIDNotification();
						canInsert = false;
					}

				}else {
					canInsert = false;
					wrongInputNotification();
				}
				//############################################################################
				//Card Number
				String cardNumberFinal = null;
				String cardNumber1 = cardNumberPart1Field.getText();
				String cardNumber2 = cardNumberPart2Field.getText();
				String cardNumber3 = cardNumberPart3Field.getText();
				String cardNumber4 = cardNumberPart4Field.getText();
				
				if(check.isThatFourNumber(cardNumber1) && check.isThatFourNumber(cardNumber2) && check.isThatFourNumber(cardNumber3) && check.isThatFourNumber(cardNumber4)) {
					cardNumberFinal = cardNumber1 + "-" + cardNumber2 + "-" + cardNumber3 + "-" +cardNumber4;
					System.out.println(cardNumberFinal);
				}else {
					canInsert = false;
				}
				
				
				//############################################################################
				//Validation
				String validFinal = null;
				String validNumber1 = validPartOne.getText();
				String validNumber2 = validPartTwo.getText();
				int subed = 1;
				if(check.isThatPartOne(validNumber1) && check.isThatPartTwo(validNumber2)) {
					validFinal = validNumber1 + "/" + validNumber2;
					System.out.println(validFinal);
				}else {
					canInsert = false;
				}
				
				
				
				//############################################################################
				//CVV
				int finalCvv = 0;
				String CVV = cvvField.getText();
				if(check.isThatInt(CVV)) {
					int cvvNum = Integer.parseInt(CVV);
					if(check.isThatCVV(cvvNum)) {
						finalCvv = cvvNum; 
					}else {
						CustomNotification("A CVV nem 3 számjegyû", 0);
						canInsert = false;
					}
				}else {
					CustomNotification("A CVV kód nem szám típusú", 0);
					canInsert = false;
				}
				
				//############################################################################
				//MORE
				
				//Dátum
				String date = null; 
				if(check.isThatDate(textField_10.getText())) {
					date = textField_10.getText();
					System.out.println(date);
				}else {
					CustomNotification("Nem dátum típúsú (dd.MM.yyyy)", 0);
					canInsert = false;
				}
				
				
				//ID kiosztás
				int id = dbm.makeNewID("users", "uid");
				System.out.println(id);
				//############################################################################
				//INSERT
				String sqlp = "insert into users values (" + id + ", '" + username + "', '" + pswd + "' , " + sID + ", '" + date + "', '" + cardNumberFinal + "', '"+ validFinal +"', "+ finalCvv +", "+ id +");";
				System.out.println(sqlp);
				
				if(canInsert != false) {
					dbm.CommandExecute(sqlp);
					CustomNotification("Sikeres felvitel", 1);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(323, 220, 103, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Felhaszn\u00E1l\u00F3n\u00E9v:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 12, 103, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblJelsz = new JLabel("Jelsz\u00F3:");
		lblJelsz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblJelsz.setBounds(10, 35, 85, 13);
		contentPane.add(lblJelsz);
		
		JLabel lblSzolgltatsId = new JLabel("Szolg\u00E1ltat\u00E1s ID");
		lblSzolgltatsId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSzolgltatsId.setBounds(10, 58, 103, 13);
		contentPane.add(lblSzolgltatsId);
		
		JLabel lblKrtyaSzm = new JLabel("K\u00E1rtya Sz\u00E1m:");
		lblKrtyaSzm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm.setBounds(10, 81, 103, 13);
		contentPane.add(lblKrtyaSzm);
		
		JLabel lblKrtyaSzm_1 = new JLabel("- ");
		lblKrtyaSzm_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1.setBounds(52, 108, 15, 13);
		contentPane.add(lblKrtyaSzm_1);
		
		cardNumberPart1Field = new JTextField();
		cardNumberPart1Field.setBounds(10, 106, 32, 19);
		contentPane.add(cardNumberPart1Field);
		cardNumberPart1Field.setColumns(10);
		
		cardNumberPart2Field = new JTextField();
		cardNumberPart2Field.setColumns(10);
		cardNumberPart2Field.setBounds(62, 106, 32, 19);
		contentPane.add(cardNumberPart2Field);
		
		JLabel lblKrtyaSzm_1_1 = new JLabel("- ");
		lblKrtyaSzm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1_1.setBounds(105, 109, 15, 13);
		contentPane.add(lblKrtyaSzm_1_1);
		
		cardNumberPart3Field = new JTextField();
		cardNumberPart3Field.setColumns(10);
		cardNumberPart3Field.setBounds(120, 106, 32, 19);
		contentPane.add(cardNumberPart3Field);
		
		JLabel lblKrtyaSzm_1_1_1 = new JLabel("- ");
		lblKrtyaSzm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1_1_1.setBounds(162, 108, 15, 13);
		contentPane.add(lblKrtyaSzm_1_1_1);
		
		cardNumberPart4Field = new JTextField();
		cardNumberPart4Field.setColumns(10);
		cardNumberPart4Field.setBounds(172, 106, 32, 19);
		contentPane.add(cardNumberPart4Field);
		
		JLabel lblKrtyaSzm_2 = new JLabel("Lej\u00E1rat:");
		lblKrtyaSzm_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_2.setBounds(10, 139, 103, 13);
		contentPane.add(lblKrtyaSzm_2);
		
		JLabel lblKrtyaSzm_1_2 = new JLabel("/");
		lblKrtyaSzm_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKrtyaSzm_1_2.setBounds(59, 164, 15, 13);
		contentPane.add(lblKrtyaSzm_1_2);
		
		usernameTextField = new JTextField();
		usernameTextField.setColumns(10);
		usernameTextField.setBounds(130, 12, 175, 19);
		contentPane.add(usernameTextField);
		
		pswdField = new JTextField();
		pswdField.setColumns(10);
		pswdField.setBounds(130, 35, 175, 19);
		contentPane.add(pswdField);
		
		serviceField = new JTextField();
		serviceField.setColumns(10);
		serviceField.setBounds(130, 58, 60, 19);
		contentPane.add(serviceField);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCvv.setBounds(10, 199, 32, 13);
		contentPane.add(lblCvv);
		
		cvvField = new JTextField();
		cvvField.setColumns(10);
		cvvField.setBounds(130, 199, 32, 19);
		contentPane.add(cvvField);
		
		validPartOne = new JTextField();
		validPartOne.setColumns(10);
		validPartOne.setBounds(10, 162, 32, 19);
		contentPane.add(validPartOne);
		
		validPartTwo = new JTextField();
		validPartTwo.setColumns(10);
		validPartTwo.setBounds(84, 163, 32, 19);
		contentPane.add(validPartTwo);
		
		JLabel lblCvv_1 = new JLabel("El\u0151fizet\u00E9s kezdete:");
		lblCvv_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCvv_1.setBounds(10, 223, 110, 13);
		contentPane.add(lblCvv_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(130, 224, 84, 19);
		contentPane.add(textField_10);
	}
	
	
	//
	
	
	
	
	
	
	//Messeges
	
	public static void CustomNotification(String msg, int sign) {
		JOptionPane.showMessageDialog(null, msg, "Vigyázat!", sign);
	}
	
	public void wrongInputNotification() {
		JOptionPane.showMessageDialog(null, "Rossz adat megadás!", "Vigyázat!", 0);
	}
	
	public void notExsitingIDNotification() {
		JOptionPane.showMessageDialog(null, "Nem létezõ elemre hivatkozik!", "Vigyázat!", 0);
	}
	
}
