package com.church.library.utils;

import java.io.Serializable;
import java.util.Date;

public class SessionUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long uid;		//用户唯一标识
	private String loginName;	//登录名
	private String isRemember;	//是否记住
	private Date gmtLogin;	//登录时间
	
	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getIsRemember() {
		return isRemember;
	}
	
	public void setIsRemember(String isRemember) {
		this.isRemember = isRemember;
	}
	
	public Date getGmtLogin() {
		return gmtLogin;
	}
	
	public void setGmtLogin(Date gmtLogin) {
		this.gmtLogin = gmtLogin;
	}

}
