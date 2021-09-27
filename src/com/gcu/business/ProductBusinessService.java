package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.Product;

public class ProductBusinessService implements ProductBusinessInterface{
	
	private static List<Product> products = null;
	private static int currentID = 0;
	
	
	@Override
	public boolean AddNewProduct(Product product) {
		product.setId(currentID);
		currentID++;
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
	
	@Override
	public boolean RemoveProduct(int productID) {
		boolean result = false;
		if(products == null)
			return result;
		
		for(Product p : products) {
			if(p.getId() == productID) {
				result = products.remove(p);
				break;
			}
		}
		return result;
	}
	
	private void SetupMockProductsList() {
		products = new ArrayList<Product>();
		
		for(int i = 0;i < 31;i++)
		{
			Product p = new Product();
			p.setId(currentID);
			currentID++;
			p.setName("Shirt " + i);
			String dollars = Integer.toString((i + 1) * 3);
			String cents = Integer.toString(((i + 1) * 4) % 100);
			p.setCost(dollars + "." + cents);
			products.add(p);
		}
	}
}
