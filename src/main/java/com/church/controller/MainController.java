package com.church.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/main")
public class MainController extends BaseController{

	@RequestMapping(method=RequestMethod.GET)
	public String main(HttpServletRequest request, ModelMap out) {
		out.put("user", getSessionUser(request));
		return "main";
	}
	
}
