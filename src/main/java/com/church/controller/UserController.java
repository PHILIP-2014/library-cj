package com.church.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.church.model.UserModel;
import com.church.service.UserService;
import com.church.utils.ServiceException;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		
		return null;
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public UserModel postLogin(HttpServletRequest request, HttpServletResponse response, 
			UserModel user){
	
		try {
			
			return userService.doLogin(user);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
