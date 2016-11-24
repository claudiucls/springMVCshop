package com.claudiucls.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.claudiucls.dao.ProductDao;
import com.claudiucls.model.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
	@RequestMapping("/productList")
	public String getProductList(Model model){
		model.addAttribute("products", productDao.getAllProducts());
		return "productList";
	}
	
	@RequestMapping("/productDetail/{id}")
	public String getProductDetail(@PathVariable Long id,Model model){
		model.addAttribute("product", productDao.getProductById(id));
		return "product-detail";
	}
	
	@RequestMapping("/admin")
	public String goAdmin(){
		return "admin";
	}
	
	@RequestMapping(value="/admin/addProduct", method=RequestMethod.GET)
	public String addProduct(Model model){
		Product product =new Product();
		product.setStatus("active");
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@RequestMapping(value="/admin/addProduct", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product){
		productDao.addProduct(product);
		return "redirect:/admin/products";
	}	
	
	@RequestMapping("/admin/products")
	public String showManageProducts(Model model){
		model.addAttribute("products", productDao.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/admin/delete/{id}")
	public String deleteProduct(@PathVariable Long id,Model model){
		productDao.deleteProduct(id);
		return "redirect:/admin/products";
	}
	

}
