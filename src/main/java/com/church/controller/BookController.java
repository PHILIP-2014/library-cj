package com.church.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/book")
public class BookController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void getList(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void create(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public void update(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public void search(HttpServletRequest request, HttpServletResponse response){
		
	}
}
