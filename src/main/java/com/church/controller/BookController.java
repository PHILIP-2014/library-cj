package com.church.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.church.model.BookCond;
import com.church.model.BookModel;
import com.church.service.BookService;


/**
 * @author PHILIP2014
 *
 */
@Controller
@RequestMapping(value="/book")
public class BookController extends BaseController {
	
	private static Logger log = Logger.getLogger(BookController.class);
	
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
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String showUpload(){
		return "admin/upload";
	}
	
	@RequestMapping(value="/doUpload", method=RequestMethod.POST)
	public String doUpload(MultipartFile file) throws IOException{
		if(file.isEmpty()){
			
		}
		log.debug("Process file:{}" + file.getOriginalFilename());
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/home/philip/dev/testUp", System.currentTimeMillis()+file.getOriginalFilename()));
		return "success";
		
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public void search(HttpServletRequest request, HttpServletResponse response){
		
	}
}
