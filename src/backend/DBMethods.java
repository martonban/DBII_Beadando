package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMethods {
	private Statement s = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	
	
	//###################
	//Methods
	
	public int signIn(String name, String pswd) {
		Connect();
		int pc = -1;
		String sqlp = "select count(*) pc from admin where name ='"+name+"' and pass='"+pswd+"';";
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				pc = rs.getInt("pc");
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		disConnect();
		return pc;
	}
	
	
	public ArrayList<Integer> serviceID() {
		Connect();
		String sqlp = "select sid from service;";
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				ids.add(rs.getInt("sid"));

			}
		}catch(SQLException e) {
			System.out.println("Problem");
		}
		return ids;
	}
	
	
	
	
	//###################
	//Basic Stuff
	
	
	
	public void Connect(){
		try{
			String url = "jdbc:sqlite:C:/Users/Marci/Documents/Egyetem (BSC)/4. félév/Adatbázis rendszerk II/DatabaseGyak01/adatb.db";
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
	
	
	public void disConnect() {
		try {
			conn.close();
			System.out.println("Disconnected!");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void CommandExecute(String str) {
		Connect();
		String sqlp = str;
		try {
			s = conn.createStatement();
			s.execute(sqlp);
			System.out.println("Done!");
		}catch(SQLException e) {
			System.out.println("Problem: " + e);
		}
		
	}
	
	

}
