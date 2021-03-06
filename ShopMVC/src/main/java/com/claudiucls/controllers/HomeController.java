package com.claudiucls.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.claudiucls.dao.ProductDao;
import com.claudiucls.model.Product;

@Controller
public class HomeController {
	
	@Autowired
	private ProductDao productDao;
	
	private Path path;	
	
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
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@RequestMapping(value="/admin/edit/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id")Long id,Model model){
		Product product =productDao.getProductById(id);
		model.addAttribute("product", product);
		return "product-form";
	}
	
	@RequestMapping(value="/admin/edit/addProduct", method=RequestMethod.POST)
	public String editProduct(@ModelAttribute("product") Product product,HttpServletRequest request){
		product.setStatus("active");
		productDao.addProduct(product);
		
		MultipartFile productImage = product.getPhoto();		
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"//WEB-INF//resources//images//"+product.getId()+".png");
		
		if(productImage != null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e){
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed!", e);
			}
		}
		return "redirect:/admin/products";
	}
	
	
	
	@RequestMapping(value="/admin/addProduct", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product, HttpServletRequest request){
		
		product.setStatus("active");
		productDao.addProduct(product);
		
		MultipartFile productImage = product.getPhoto();		
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"//WEB-INF//resources//images//"+product.getId()+".png");
		
		if(productImage != null && !productImage.isEmpty()){
			try{
				productImage.transferTo(new File(path.toString()));
			} catch (Exception e){
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed!", e);
			}
		}
		return "redirect:/admin/products";
	}	
	
	@RequestMapping("/admin/products")
	public String showManageProducts(Model model){
		model.addAttribute("products", productDao.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/admin/delete/{id}")
	public String deleteProduct(@PathVariable Long id,Model model,HttpServletRequest request){
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory+"//WEB-INF//resources//images//"+id+".png");
		
		
		if(Files.exists(path)){
			try{
				Files.delete(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		productDao.deleteProduct(id);
		return "redirect:/admin/products";
	}
	

}
