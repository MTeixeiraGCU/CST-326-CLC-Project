package com.gcu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
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
	
	private List<Product> GetMockList()
	{
		List<Product> products = new ArrayList<Product>();
		
		for(int i = 0;i < 31;i++)
		{
			Product p = new Product();
			p.setName("Shirt " + i);
			p.setCost(new BigDecimal("0.00" + i));
			products.add(p);
		}

		return products;
	}
}
