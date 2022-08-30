package lti.she.dto;

public class NgoLogin {
	int id;
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "NgoLogin [id=" + id + ", password=" + password + "]";
	}
	
	

}
