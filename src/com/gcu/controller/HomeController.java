package com.gcu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.User;

@Controller
public class HomeController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductBusinessInterface pbs;
	
	@RequestMapping(path= {"", "/", "/index", "/home"}, method=RequestMethod.GET)
	public ModelAndView NavToHomePage() {
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("user", new User());
		models.put("products", pbs.GetProducts());
		
		return new ModelAndView("index", "models", models);
	}
}
