package com.church.controller;

import java.io.IOException;

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
@RequestMapping(value = "/user")
public class UserController extends BaseController {

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
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public UserModel create(HttpServletRequest request, HttpServletResponse response,
			UserModel userModel) throws IOException {

		try {
			return userService.doCreate(userModel, getUid(request));
		} catch (ServiceException e) {
			sendError(request, response, e.getMessage());
		}
		return null;
	}

}
