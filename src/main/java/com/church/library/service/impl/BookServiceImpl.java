package com.church.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.library.dao.BookDao;
import com.church.library.model.BookModel;
import com.church.library.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	public BookModel queryModel(Long id, Long uid) {
		//TODO
		return bookDao.queryOne(id);
	}
	
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
