package com.demo.actutor.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.demo.actutor.model.User;



@RestController
@RequestMapping(path = "/user")
public class RegistrationController {

	@GetMapping(path = "/registration")
	public String showRegistrationForm(WebRequest request, Model model) {
		User userDto = new User();
		model.addAttribute("user", userDto);
		return "registration";
	}
}
