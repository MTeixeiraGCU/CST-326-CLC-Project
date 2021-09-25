package com.gcu.business;

import java.math.BigDecimal;
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
			p.setCost(new BigDecimal(i + ".00"));
			products.add(p);
		}
	}
}
