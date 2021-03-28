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
	private CheckMethods check = new CheckMethods();

	
	
	
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
	
	
	
	public String getAdminNameWithID(int aid) {
		Connect();
		String sqlp = "select name from admin where id = '" + aid +"';";
		String name = null;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				name = rs.getString("name");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return name;
	}
	
	
	
	public UserTM ReadAllUsers() {
		Object usertm[] = {"Jel","Uid","Név","Jelszo","Elõfizetés","Kezdet", "Kártyaszám", "Érvényeség", "CVV", "Subed?"};
		UserTM utm = new UserTM(usertm, 0);
		String username="", pass="", begin="", cardnumber="", valid="";
		int uid=0, sid=0, cvv=0, subed=0;
		String sqlp = "select uid, username, pass, sid, begin, cardnumber, valid, cvv, subed from users";
		Connect();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				uid= rs.getInt("uid");
				username = rs.getString("username");
				pass = rs.getString("pass");
				begin = rs.getString("begin");
				cardnumber = rs.getString("cardnumber");
				valid = rs.getString("valid");
				sid= rs.getInt("sid");
				cvv= rs.getInt("cvv");
				subed= rs.getInt("subed");
				utm.addRow(new Object[] {false, uid, username, pass, sid, begin, cardnumber, valid, cvv, subed});
				
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println("asd");
		}
		disConnect();
		return utm;
	}
	
	
	public ServiceTM ReadAllService(int min, int max) {
		Object stmt[] = {"Jel","Sid","Név","Ár"};
		ServiceTM stm = new ServiceTM(stmt, 0);
		String username="";
		int id=0,  ar=0;
		String sqlp = "select sid, sname, price from services where price<=" + max + " and price>=" + min;
		Connect();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				id= rs.getInt("sid");
				username = rs.getString("sname");
				ar= rs.getInt("price");
				stm.addRow(new Object[] {false, id, username, ar});
				
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println("asd");
		}
		disConnect();
		return stm;
	}
	
	
	
	
	
	
	public void deleteRecord(String needTable, String nameOFTheIDFiled, int id) {
		boolean canDelete = true; 
		//Validation
		if(needTable.equals("services")) {
			noti.CustomNotification("A 'szolgáltatás' nem törölhetõ vegye fel a kapcsolatott az üzemltetõvel!", 0);
		}
		if(needTable.equals("admin") != false  || needTable.equals("users") !=false ) {
			System.out.println("OK");
		}else {
			canDelete = false;
			noti.CustomNotification("Nem létezõ tábla", 0);
		}
		if(nameOFTheIDFiled.equals("id") != false || nameOFTheIDFiled.equals("uid") != false) {
			System.out.println("OK");
		}else {
			canDelete = false;
			noti.CustomNotification("Nem létezõ mezõ", 0);
		}
		if(id<0) {
			canDelete = false;
			noti.CustomNotification("Nem értelmezhetõ ID", 0);
		}
		//Delete
		if(canDelete == true) {
			String sqlp = "delete from " + needTable + " where "+nameOFTheIDFiled+"  = " + id + ";";
			CommandExecute2(sqlp);
		}
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
	
	/*
	public User getUser(int id) {
		User user;
		String username="", pass="", begin="", cardnumber="", valid="";
		int uid=0, sid=0, cvv=0, subed=0;
		String sqlp = "select uid, username, pass, sid, begin, cardnumber, valid, cvv, subed from users where uid = "+id+";";
		Connect();
		try {
			s = conn.createStatement();
			rs = s.executeQuery(sqlp);
			while(rs.next()) {
				uid= rs.getInt("uid");
				username = rs.getString("username");
				pass = rs.getString("pass");
				begin = rs.getString("begin");
				cardnumber = rs.getString("cardnumber");
				valid = rs.getString("valid");
				sid= rs.getInt("sid");
				cvv= rs.getInt("cvv");
				subed= rs.getInt("subed");
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println("Problem");
		}
		
		user = new User(uid, username, pass, sid, begin, cardnumber, valid, cvv, subed);
		return user;
	}
	*/
	
	//############################################################################
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
		}catch(SQLException e) {
			System.out.println("Problem: " + e);
		}
		
	}
	
	public void CommandExecute2(String str) {
		Connect();
		String sqlp = str;
		try {
			s = conn.createStatement();
			s.execute(sqlp);
		}catch(SQLException e) {
			noti.CustomNotification("Nem létezõ tábla mezõ kombináció", 0);
		}
		
	}

}
