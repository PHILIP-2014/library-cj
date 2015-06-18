package com.church.dao;

import com.church.model.BookModel;

public interface BookDao {

	public Long insert(BookModel bookModel);
	
	public BookModel queryOne(Long id);
	
	public Integer update(BookModel bookModel);
	
	public Integer delete(Long id);
	
}