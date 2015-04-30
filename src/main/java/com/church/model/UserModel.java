package com.church.model;

public class UserModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	public static final int STATUS_TRUE = 1;
	
    private String name;

    private String password;
    
    private String phone;
    
    private Integer role;
   
    private Integer status;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
