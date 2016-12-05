package com.claudiucls.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.claudiucls.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sf;
	private Session session;

	@Override
	public void addProduct(Product product) {
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(product);
		
	}

	@Override
	public Product getProductById(long id) {
		Session session = sf.getCurrentSession();
		return session.find(Product.class, id);
	}

	@Override
	public List<Product> getAllProducts() {
		session = sf.getCurrentSession();
		List<Product> products = session.createQuery("Select p from Product p").getResultList();
		return products;
	}

	@Override
	public void deleteProduct(long id) {
		Session session = sf.getCurrentSession();
		session.delete(getProductById(id));
	}

}
