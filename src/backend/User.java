package backend;

public class User {
	
	private int uid;
	private String username;
	private String pass;
	private int sid;
	private String begin;
	private String cardnumber;
	private String valid;
	private int cvv;
	private int subed;
	
	
	public User(int uid, String username, String pass, int sid, String begin, String cardnumber, String valid, int cvv, int subed) {
		super();
		this.uid = uid;
		this.username = username;
		this.pass = pass;
		this.sid = sid;
		this.begin = begin;
		this.cardnumber = cardnumber;
		this.valid = valid;
		this.cvv = cvv;
		this.subed = subed;	
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getBegin() {
		return begin;
	}


	public void setBegin(String begin) {
		this.begin = begin;
	}


	public String getCardnumber() {
		return cardnumber;
	}


	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}


	public String getValid() {
		return valid;
	}


	public void setValid(String valid) {
		this.valid = valid;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public int getSubed() {
		return subed;
	}


	public void setSubed(int subed) {
		this.subed = subed;
	}
	
	
	
	
	

}
