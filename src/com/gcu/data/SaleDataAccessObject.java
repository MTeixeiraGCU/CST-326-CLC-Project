package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.gcu.model.Sale;

public class SaleDataAccessObject implements DataAccessObjectInterface<Sale> {

	private static List<Sale> sales = null;
	private static int currentID = 0;
	
	@PostConstruct
	public void Initialize() {
		sales = new ArrayList<Sale>();
		for(int i = 0;i < 12;i++) {
			Sale s = new Sale();
			s.setId(currentID);
			s.setName("Sale #" + currentID);
			s.setAmount(currentID);
			sales.add(s);
			currentID++;
		}
	}
	
	@Override
	public Sale get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> getAll() {
		return sales;
	}

	@Override
	public boolean add(Sale t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Sale t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Sale t) {
		// TODO Auto-generated method stub
		return false;
	}

}
