package com.church.service;

import com.church.model.BookModel;

public interface BookService {

	public BookModel doCreate(BookModel bookModel, Long uid);
	
	public BookModel doUpdate(BookModel bookModel, Long bid, Long uid);
	
	public Boolean doDelete(Long bid, Long uid);
}
