package com.gcu.business;

import java.util.List;

import com.gcu.model.Product;

public interface ProductBusinessInterface {
	
	public boolean AddNewProduct(Product product);
	public List<Product> GetProducts();
}
