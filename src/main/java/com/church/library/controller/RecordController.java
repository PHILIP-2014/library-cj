package com.church.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/record")
public class RecordController {

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public void getList(){
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void create(){
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public void update(){
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(){
		
	}
}
