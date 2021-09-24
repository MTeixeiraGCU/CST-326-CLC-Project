package com.gcu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.Product;
import com.gcu.model.User;

@Controller
public class HomeController {

	@RequestMapping(path= {"", "/", "/index", "/home"}, method=RequestMethod.GET)
	public ModelAndView NavToHomePage() {
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("user", new User());
		models.put("products", GetMockList());
		
		return new ModelAndView("index", "models", models);
	}
	
	@RequestMapping(path= {"/inventory"}, method=RequestMethod.GET)
	public ModelAndView NavInventoryPage(ModelMap model) {
		model.addAttribute("products", GetMockList());
		model.addAttribute("newProduct", new Product());
		return new ModelAndView("inventory", "model", model);
	}
	
	@RequestMapping(path="/addProduct", method=RequestMethod.POST)
	public ModelAndView AddNewProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("msg", "Could not add product!");			
		}
		else
		{
			model.addAttribute("msg", "Product was added!");
		}
		
		model.addAttribute("products", GetMockList());
		return new ModelAndView("inventory", "model", model);
	}
	
	private List<Product> GetMockList()
	{
		List<Product> products = new ArrayList<Product>();
		
		for(int i = 0;i < 31;i++)
		{
			Product p = new Product();
			p.setName("Shirt " + i);
			p.setCost(new BigDecimal(i + ".00"));
			products.add(p);
		}

		return products;
	}
}
