package com.church.library.utils;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(){
		super();
	}

	public ServiceException(String msg){
		super(msg);
	}

	public ServiceException(String msg, Throwable cause){
		super(msg, cause);
	}
}
