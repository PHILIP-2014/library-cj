package com.church.library.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.church.library.model.BookCond;
import com.church.library.model.BookModel;
import com.church.library.service.BookService;


/**
 * @author philip
 *
 */
@Controller
@RequestMapping(value="/book")
public class BookController extends BaseController {
	
	@Autowired
	private BookService bookService;

	/**
	 * 获取书籍列表
	 * @param request
	 * @param response
	 * @param bookCond
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getList(HttpServletRequest request, HttpServletResponse response, 
		BookCond bookCond){

		return "book";
	}
	
	/**
	 * 获取书籍详情
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public BookModel getOne(HttpServletRequest request, HttpServletResponse response,
			@PathVariable Long id){
		
		return bookService.queryModel(id, getUid(request));
	}

	/**
	 * 新增书籍
	 * @param request
	 * @param response
	 * @param bookModel
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public BookModel create(HttpServletRequest request, HttpServletResponse response,
			BookModel bookModel){
		
		return bookService.doCreate(bookModel, getUid(request));
	}
	
	/**
	 * 更新书籍
	 * @param request
	 * @param response
	 * @param bookModel
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BookModel update(HttpServletRequest request, HttpServletResponse response,
			@RequestBody BookModel bookModel, @PathVariable Long id){
		
		return bookService.doUpdate(bookModel, id, getUid(request));
	}
	
	/**
	 * 删除书籍
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable Long id){
		
		bookService.doDelete(id, getUid(request));
		return null;
	}
	
	/**
	 * 搜索书籍
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public void search(HttpServletRequest request, HttpServletResponse response){
		
	}
}
