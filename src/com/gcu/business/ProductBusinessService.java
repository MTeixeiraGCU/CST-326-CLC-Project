package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.Product;

public class ProductBusinessService implements ProductBusinessInterface{
	
	public List<Product> products = null;
	
	@Override
	public boolean AddNewProduct(Product product) {
		products.add(product);
		return true;
	}
	
	@Override
	public List<Product> GetProducts() {
		if(products == null) {
			SetupMockProductsList();
		}
		return products;
	}
	
	private void SetupMockProductsList() {
		products = new ArrayList<Product>();
		
		for(int i = 0;i < 31;i++)
		{
			Product p = new Product();
			p.setName("Shirt " + i);
			String dollars = Integer.toString((i + 1) * 3);
			String cents = Integer.toString(((i + 1) * 4) % 100);
			p.setCost(dollars + "." + cents);
			products.add(p);
		}
	}
}
