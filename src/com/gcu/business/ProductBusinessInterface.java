package com.gcu.business;

import java.util.List;

import com.gcu.model.Product;
import com.gcu.model.Sale;

public interface ProductBusinessInterface {
	
	public boolean AddNewProduct(Product product);
	public List<Product> GetProducts();
	public boolean RemoveProduct(int productID);
	
	public boolean AddNewSale(Sale sale);
	public List<Sale> GetSales();
	public boolean RemoveSale(int saleID);
}
