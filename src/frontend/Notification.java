package frontend;

import javax.swing.JOptionPane;

public class Notification {
	
	
	public static void CustomNotification(String msg, int sign) {
		JOptionPane.showMessageDialog(null, msg, "Vigyázat!", sign);
	}

}
