package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import frontend.Notification;

public class DBMethods {
	private Statement s = null;
	private Connection conn = null;
	private ResultSet rs = null;
	private Notification noti = new Notification();

	
	
	
	//############################################################################
	//Methods
	
	
	public int makeNewID(String needTable, String nameOFTheIDFiled) {
		Connect();
		String sqlp = "select "+ nameOFTheIDFiled + " from " + needTable +";";
		ArrayList<Integer> ids = new ArrayList<Integer>();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				ids.add(rs.getInt(nameOFTheIDFiled));

			}
		}catch(SQLException e) {
			System.out.println("Problem");
		}
		
		
		int newID = 0;
		int size = ids.size();
		newID = ids.get(size-1) + 1;
		
		return newID;
	}
	
	
	public void deleteRecord(String needTable, String nameOFTheIDFiled, int ID) {
		//Validation
		if(needTable.equals("admin") != false || needTable.equals("services") != false || needTable.equals("users") !=false ) {
			System.out.println("OK");
		}else {
			noti.CustomNotification("Nem l�tez� t�bla", 0);
		}
		
		
		
		//Delete
		
		
		
	}
	
	
	
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
	
	
	
	
	//############################################################################
	//Basic Stuff
	
	
	
	public void Connect(){
		try{
			String url = "jdbc:sqlite:C:/Users/Marci/Documents/Egyetem (BSC)/4. f�l�v/Adatb�zis rendszerk II/DatabaseGyak01/adatb.db";
			conn = DriverManager.getConnection(url);
			System.out.println(" OK!");
		}catch(SQLException e) {
			System.out.println("JDBC Connect: " + e.getMessage());
		}
		
	}
	
	public void Reg() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Sikeres driver regisztr�ci�!");
		}catch(ClassNotFoundException e){
			System.out.println("hib�s driver regisztr�ci�!" +e.getMessage());
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
		}catch(SQLException e) {
			System.out.println("Problem: " + e);
		}
		
	}
	
	

}
