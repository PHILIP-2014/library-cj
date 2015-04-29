package com.church.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date gmtCreate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date gmtModify;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtModify() {
		return gmtModify;
	}
	
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	
}
