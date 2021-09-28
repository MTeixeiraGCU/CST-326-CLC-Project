package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessObjectInterface;
import com.gcu.model.Product;
import com.gcu.model.Sale;

public class ProductBusinessService implements ProductBusinessInterface{
	
	@Autowired
	private DataAccessObjectInterface<Product> pdao;
	@Autowired
	private DataAccessObjectInterface<Sale> sdao;
	
	@Override
	public boolean AddNewProduct(Product product) {
		return pdao.add(product);
	}
	
	@Override
	public List<Product> GetProducts() {
		return pdao.getAll();
	}
	
	@Override
	public boolean RemoveProduct(int productID) {
		return pdao.delete(pdao.get(productID));
	}

	@Override
	public boolean AddNewSale(Sale sale) {
		return false;
	}

	@Override
	public List<Sale> GetSales() {
		return sdao.getAll();
	}

	@Override
	public boolean RemoveSale(int saleID) {
		return false;
	}
}
