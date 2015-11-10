package com.church.library.model;

public class DocModel extends BaseModel {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private Long uidUpload;
	
	private String suffix;
	
	private String size;
	
	private String md5;
	
	private Boolean isTrash;
	
	private Long uidTrash;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUidUpload() {
		return uidUpload;
	}

	public void setUidUpload(Long uidUpload) {
		this.uidUpload = uidUpload;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Boolean getIsTrash() {
		return isTrash;
	}

	public void setIsTrash(Boolean isTrash) {
		this.isTrash = isTrash;
	}

	public Long getUidTrash() {
		return uidTrash;
	}

	public void setUidTrash(Long uidTrash) {
		this.uidTrash = uidTrash;
	}
	
}
