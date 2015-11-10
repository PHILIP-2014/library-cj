package com.church.library.model;

public class UserModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	public static final int ROLE_NORMAL = 1;
	public static final int ROLE_ADMIN = 2;
	
    private String name;

    private String password;
    
    private String phone;
    
    private Integer role;
   
    private Boolean isVerify;
    
    private Boolean isDisable;
    
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

	public Boolean getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(Boolean isVerify) {
		this.isVerify = isVerify;
	}

	public Boolean getIsDisable() {
		return isDisable;
	}

	public void setIsDisable(Boolean isDisable) {
		this.isDisable = isDisable;
	}

}
