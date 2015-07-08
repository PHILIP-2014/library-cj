package com.church.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.church.model.UserModel;
import com.church.service.UserService;
import com.church.utils.ServiceException;

@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		
		return null;
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public UserModel postLogin(HttpServletRequest request, HttpServletResponse response, 
			UserModel user) throws IOException {
		try {
			UserModel userModel = userService.doLogin(user);
			setSessionUser(request, userService.initSessionUser(userModel));
			return userModel;
		} catch (ServiceException e) {
			sendError(request, response, e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, RedirectAttributes redirectAttr) {
		removeSession(request, SESSION_KEY);
		return "redirect:/login.htm"; //FIXME
	}
}
