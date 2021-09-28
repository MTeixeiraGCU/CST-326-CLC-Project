package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.gcu.model.Product;

public class ProductDataAccessObject implements DataAccessObjectInterface<Product> {

	private static List<Product> products = null;
	private static int currentID = 0;
	
	@PostConstruct
	public void Initialize() {
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
	
	@Override
	public Product get(int id) {
		for(Product p : products) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

	@Override
	public boolean add(Product t) {
		t.setId(currentID);
		currentID++;
		return products.add(t);
	}

	@Override
	public boolean update(Product t) {
		for(int i = 0;i < products.size();i++) {
			if(products.get(i).getId() == t.getId()) {
				products.set(i, t);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Product t) {
		return products.remove(t);
	}

}
