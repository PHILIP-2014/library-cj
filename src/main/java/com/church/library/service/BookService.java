package com.church.library.service;

import com.church.library.model.BookModel;

public interface BookService {

	public BookModel queryModel(Long id, Long uid);
	
	public BookModel doCreate(BookModel bookModel, Long uid);
	
	public BookModel doUpdate(BookModel bookModel, Long bid, Long uid);
	
	public Boolean doDelete(Long bid, Long uid);
}
