package com.church.library.model;

import java.util.Date;

public class RecordModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Long bid;
	
	private Long uid;
	
	private Boolean flagBorrow;
	
	private Date gmtBorrow;
	
	private Date gmtToReturn;
	
	private Boolean flagReturn;
	
	private Date gmtReturn;
	
	private Integer status;
	
	public Long getBid() {
		return bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Boolean getFlagBorrow() {
		return flagBorrow;
	}

	public void setFlagBorrow(Boolean flagBorrow) {
		this.flagBorrow = flagBorrow;
	}

	public Date getGmtBorrow() {
		return gmtBorrow;
	}

	public void setGmtBorrow(Date gmtBorrow) {
		this.gmtBorrow = gmtBorrow;
	}

	public Date getGmtToReturn() {
		return gmtToReturn;
	}

	public void setGmtToReturn(Date gmtToReturn) {
		this.gmtToReturn = gmtToReturn;
	}

	public Boolean getFlagReturn() {
		return flagReturn;
	}

	public void setFlagReturn(Boolean flagReturn) {
		this.flagReturn = flagReturn;
	}

	public Date getGmtReturn() {
		return gmtReturn;
	}

	public void setGmtReturn(Date gmtReturn) {
		this.gmtReturn = gmtReturn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
