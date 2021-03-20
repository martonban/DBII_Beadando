package backend;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class CheckMethods {
	
	
	//ArrayList Realtied
	
	public boolean exsitInArrayList(ArrayList<Integer> arr, int need) {
		int count = 0;
		for(int i : arr) {
			if(i == need) {
				count++;
			}
		}
		if (count == 0) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	
	

	// Credit Card Related Methods
	
	public static boolean isThatCVV(int cvv) {
		if(cvv < 1000 && cvv > 99) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean isThatFourNumber(String strNum) {
		System.out.println("IN");
		boolean check = true;
		int d = 0;
		if (strNum == null) {
			CustomNotification("Nincs input", 0);
	        return false;
	    }
	    try {
	        d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
			CustomNotification("Rossz Formátum", 0);
	        return false;
	    }
		
	    d = Integer.parseInt(strNum);
	    System.out.println(d);
		if(d > 999 && d < 10000) {
			System.out.println("Cool");
		}else {
			CustomNotification("Négy darab számot adjon meg kérem!", 2);
			return false;
		}
		
		return check;
	}
	
	
	
	
	// Basic Data Type
	
	public static boolean isThatInt(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	public static boolean isThatDate(String a) {
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		sdf.setLenient(false);
		try {
			sdf.parse(a);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	
	//Notificaton
	
	public static void CustomNotification(String msg, int sign) {
		JOptionPane.showMessageDialog(null, msg, "Vigyázat!", sign);
	}
	
	
}
