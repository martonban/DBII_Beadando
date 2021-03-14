package backend;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CheckMethods {
	

	// Credit Card Related Methods
	
	public static boolean isThatCVV(int cvv) {
		if(cvv < 1000 && cvv > 99) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isThatFourNumber(int num) {
		if(num > 999 && num < 10000) {
			return true;
		}else {
			return false;
		}
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


}
