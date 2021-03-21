package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import backend.*;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DevTool extends JFrame {

	private JPanel contentPane;
	private JTextField sqlField;
	private static DBMethods dbm = new DBMethods(); 
	private static CheckMethods ch = new CheckMethods();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dbm.Reg();
		dbm.Connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevTool frame = new DevTool();
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
	public DevTool() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sqlField = new JTextField();
		sqlField.setBounds(10, 10, 416, 19);
		contentPane.add(sqlField);
		sqlField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 39, 416, 175);
		contentPane.add(textPane);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dbm.deleteRecord("services", "id", 9);

				
			}
		});
		btnNewButton.setBounds(10, 232, 85, 21);
		contentPane.add(btnNewButton);
	}
}
