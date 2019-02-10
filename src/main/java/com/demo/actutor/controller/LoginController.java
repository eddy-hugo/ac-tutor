package com.demo.actutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.actutor.model.User;
import com.demo.actutor.service.UserService;



@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping(path="/login")
    public ModelAndView showSignUp(ModelAndView modelAndView) {
		modelAndView.setViewName("login");
		return modelAndView;
    }
	
	@GetMapping(value = "/user/test")
	public ModelAndView test() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("userMessage", "Content Available Only for Users with <Strong><em>User</em></Strong> Role");
		modelAndView.setViewName("user/test");
		return modelAndView;
	}
}
