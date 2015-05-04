package com.church.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.church.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户中心
	 * 
	 * @return
	 */
	@RequestMapping(value = "/center", method = RequestMethod.GET)
	public void userCenter(HttpServletRequest request) {
		
	}

}
