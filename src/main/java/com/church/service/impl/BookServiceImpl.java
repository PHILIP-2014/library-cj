package com.church.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.dao.BookDao;
import com.church.model.BookModel;
import com.church.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	public BookModel create(BookModel bookModel){
		bookDao.insert(bookModel);
		return bookModel;
	}
}
