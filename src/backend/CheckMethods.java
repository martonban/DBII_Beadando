package backend;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class CheckMethods {
	
	
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
