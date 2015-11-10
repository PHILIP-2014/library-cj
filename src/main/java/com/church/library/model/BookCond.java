package com.church.library.model;

import java.io.Serializable;

public class BookCond implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer type;

	private String author;
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
