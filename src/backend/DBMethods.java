package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMethods {
	private Statement s = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	public void Connection(){
		try{
			String url = "jdbc:sqlite:C:/Users/Marci/Documents/Egyetem (BSC)/4. félév/Adatbázis rendszerk II/DatabaseGyak01/empdb.db";
			conn = DriverManager.getConnection(url);
			System.out.println(" OK!");
		}catch(SQLException e) {
			System.out.println("JDBC Connect: " + e.getMessage());
		}
		
	}
	
	public void Reg() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Sikeres driver regisztráció!");
		}catch(ClassNotFoundException e){
			System.out.println("hibás driver regisztráció!" +e.getMessage());
		}
	}

}
