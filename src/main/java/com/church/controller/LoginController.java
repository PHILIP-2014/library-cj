package com.church.controller;

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
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		
		return "practice";
	}

	@RequestMapping(method=RequestMethod.POST)
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, RedirectAttributes redirectAttr) {
		request.getSession().setAttribute("user", null);
		redirectAttr.addFlashAttribute("success", "登出成功");
		return "redirect:/index.do"; //FIXME
	}
}
