package com.church.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.church.model.BookModel;
import com.church.service.BookService;


@Controller
@RequestMapping(value="/book")
public class BookController extends BaseController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(method = RequestMethod.GET)
	public String getList(HttpServletRequest request, HttpServletResponse response){
		return "book";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public BookModel create(HttpServletRequest request, HttpServletResponse response,
			BookModel bookModel){
		
		return bookService.doCreate(bookModel, getUid(request));
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BookModel update(HttpServletRequest request, HttpServletResponse response,
			@RequestBody BookModel bookModel, @PathVariable Long id){
		
		return bookService.doUpdate(bookModel, id, getUid(request));
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public void search(HttpServletRequest request, HttpServletResponse response){
		
	}
}
