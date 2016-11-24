package com.claudiucls.dao;

import java.util.List;

import com.claudiucls.model.Product;

public interface ProductDao {
	void addProduct(Product product);
	
	Product getProductById(long id);
	
	List<Product> getAllProducts();
	
	void deleteProduct(long id);
}
