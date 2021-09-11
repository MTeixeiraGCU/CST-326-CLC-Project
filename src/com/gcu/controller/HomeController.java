package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.User;

@Controller
public class HomeController {

	@RequestMapping(path= {"", "/", "/index", "/home"}, method=RequestMethod.GET)
	public ModelAndView NavToHomePage() {
		return new ModelAndView("index", "user", new User());
	}
}
