package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.User;

@Controller
public class RegistrationController {

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView NavToLogin() {
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView LoginUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		
		boolean ignoreErrors = true;
		
		List<FieldError> errors = result.getFieldErrors();
		for(FieldError error : errors)
		{
			if(error.getField().equals("email") | error.getField().equals("password"))
			{
				ignoreErrors = false;
				break;
			}
		}
		
		if(!ignoreErrors) {
			return new ModelAndView("login", "user", user);
		}
		else
		{
			return new ModelAndView("index", "user", user);
		}
	}
	
}
