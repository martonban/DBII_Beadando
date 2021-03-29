package backend;

public class Service {
	private int sid;
	private String sname;
	private int price;
		
	
	public Service(int sid, String sname, int price) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
	}
	
	public int getSid() {
		return sid;
	}
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
