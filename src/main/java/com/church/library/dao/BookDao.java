package com.church.library.dao;

import com.church.library.model.BookModel;

public interface BookDao {

	public Long insert(BookModel bookModel);
	
	public BookModel queryOne(Long id);
	
	public Integer update(BookModel bookModel);
	
	public Integer delete(Long id);
	
}