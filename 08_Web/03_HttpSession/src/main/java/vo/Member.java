package vo;

public class Member {
	private String id;
	private String pwd;
	
	
	
	public Member() {
	}



	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPwd() {
		return pwd;
	}



	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + "]";
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
