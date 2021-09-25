package com.gcu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.UserBusinessInterface;
import com.gcu.model.User;

@Controller
public class RegistrationController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserBusinessInterface ubs;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView NavToLogin() {
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView LoginUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		
		if(session.getAttribute("lockedOut") != null && (boolean)session.getAttribute("lockedOut"))
		{
			session.setAttribute("msg", "You have made too many attempts and are now locked out!");
			return new ModelAndView("login", "user", user);
		}
		
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
			if(session.getAttribute("loginAttempts") == null)
			{
				session.setAttribute("lockedOut", false);
				session.setAttribute("loginAttempts", 1);
			}
			else {
				int attempts = (int)session.getAttribute("loginAttempts");
				if(attempts >= UserBusinessInterface.LOCKOUT_COUNT - 1) {
					session.setAttribute("lockedOut", true);
					session.setAttribute("msg", "You have made too many attempts and are now locked out!");
				}
				else {
					attempts++;
					session.setAttribute("loginAttempts", attempts);
					if(attempts > 6) {
						String message = String.format("You have %d attempts left!", UserBusinessInterface.LOCKOUT_COUNT - attempts);
						session.setAttribute("msg", message);
					}
				}
			}
			return new ModelAndView("login", "user", user);
		}
		else
		{
			return new ModelAndView("loginSuccess", "user", user);
		}
	}
	
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public ModelAndView RegisterUser(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
	
		if(result.hasErrors()) {
			return new ModelAndView("register", "user", user);
		}
		else
		{
			return new ModelAndView("registerSuccess", "user", user);
		}
	}

	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView NavToRegistration()
	{
		return new ModelAndView("register", "user", new User());
	}
}
