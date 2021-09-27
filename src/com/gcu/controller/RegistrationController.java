package com.gcu.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
		
		if(CheckLockoutStatus()) {
			return new ModelAndView("login", "user", user);
		}
		
		if(ubs.ValidateCredintials(user)) {
			session.setAttribute("userEmail", user.getEmail());
			session.setAttribute("admin", ubs.IsAdmin(user.getEmail()));
			return new ModelAndView("loginSuccess", "user", user);
		}
		
		session.setAttribute("msg", "Invalid credintials" + (session.getAttribute("msg") == null?"!":", " + session.getAttribute("msg")));
		return new ModelAndView("login", "user", user);
	}
	
	@RequestMapping(path= {"logout"}, method=RequestMethod.GET)
	public String LogoutUser() {
		
		if(session.getAttribute("userEmail") != null)
			session.removeAttribute("userEmail");
		if(session.getAttribute("admin") != null)
			session.removeAttribute("admin");
		return "logoutSuccess";
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
	
	private boolean CheckLockoutStatus() {
		if(session.getAttribute("lockedOut") != null && (boolean)session.getAttribute("lockedOut"))
		{
			session.setAttribute("msg", "You have made too many attempts and are now locked out!");
			return true;
		}
		
		if(session.getAttribute("loginAttempts") == null)
		{
			session.setAttribute("lockedOut", false);
			session.setAttribute("loginAttempts", 1);
			return false;
		}
		else {
			int attempts = (int)session.getAttribute("loginAttempts");
			attempts++;
			if(attempts > UserBusinessInterface.LOCKOUT_COUNT) {
				session.setAttribute("lockedOut", true);
				session.setAttribute("msg", "You have made too many attempts and are now locked out!");
				return true;
			}
			else {
				session.setAttribute("loginAttempts", (int)session.getAttribute("loginAttempts") + attempts);
				if(attempts > 6) {
					String message = String.format("You have %d attempts left!", UserBusinessInterface.LOCKOUT_COUNT - attempts);
					session.setAttribute("msg", message);
				}
				return false;
			}
		}
	}
}
