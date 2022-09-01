package lti.she.dto;

import lti.she.entity.Admin;

public class AdminDto {
	int adminId;
	String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", password=" + password + "]";
	}
	public Admin toAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setPassword(password);
		return admin;
	}

}
