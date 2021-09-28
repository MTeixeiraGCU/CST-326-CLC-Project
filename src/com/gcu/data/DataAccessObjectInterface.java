package com.gcu.data;

import java.util.List;

public interface DataAccessObjectInterface<T> {
	public T get(int id);
	public List<T> getAll();
	public boolean add(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
