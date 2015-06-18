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
	
	public BookModel doCreate(BookModel bookModel, Long uid){
		bookDao.insert(bookModel);
		return bookModel;
	}

	public BookModel doUpdate(BookModel bookModel, Long bid, Long uid) {
		bookDao.update(bookModel);
		return bookModel;
	}

	public Boolean doDelete(Long bid, Long uid) {
		bookDao.delete(bid);
		return null;
	}
}
