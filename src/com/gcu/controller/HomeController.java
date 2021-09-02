package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.User;

@Controller
public class HomeController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView NavToHomePage() {
		return new ModelAndView("index", "user", new User());
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user") User user) {
		return new ModelAndView("index", "user", user);
	}
}
