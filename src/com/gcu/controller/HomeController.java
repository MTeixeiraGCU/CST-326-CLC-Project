package com.gcu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.Product;
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
	
	@RequestMapping(path= {"/inventory"}, method=RequestMethod.GET)
	public ModelAndView NavInventoryPage(ModelMap model) {
		if(session.getAttribute("admin") == null || !(boolean)session.getAttribute("admin"))
			return NavToHomePage();
		
		model.addAttribute("products", pbs.GetProducts());
		model.addAttribute("newProduct", new Product());
		return new ModelAndView("inventory", "model", model);
	}
	
	@RequestMapping(path="/addProduct", method=RequestMethod.POST)
	public ModelAndView AddNewProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("msg", "Form errors occured, could not add product!");			
		}
		
		if(pbs.AddNewProduct(product)) {
			model.addAttribute("msg", "Product was added!");
		}
		else {
			model.addAttribute("msg", "Database errors occured, could not add product!");
		}
		
		model.addAttribute("products", pbs.GetProducts());
		return new ModelAndView("inventory", "model", model);
	}
}
