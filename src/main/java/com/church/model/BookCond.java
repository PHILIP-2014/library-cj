package com.church.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BookCond implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer type;

	private String author;
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Long type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
