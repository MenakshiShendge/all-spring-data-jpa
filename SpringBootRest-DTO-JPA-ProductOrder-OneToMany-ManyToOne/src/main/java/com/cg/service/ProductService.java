package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Orders;
import com.cg.entity.Products;
import com.cg.repository.OrderRepository;
import com.cg.repository.ProductRepository;
@Service
public class ProductService implements IProductService {
    
	List<Products> productList = new ArrayList();
    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    OrderRepository orderRepository;
	
	@Override
	public List<Products> findAllProduct() {
		return productRepository.findAll() ;
	}
	
	@Override
	public Optional<Products> findproductbyid(int id){
		return productRepository.findById(id); 
	}
	
	
	@Override
	public List<Products> findproductbyname(String pname) {
		
		return productRepository.findByPname(pname);
	}
	
	
	@Override
	public void deleteproductbyid(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public Products newproduct(Products products) {
		if(orderRepository.existsById(products.getOrders().getId())) {
				Orders o=orderRepository.findById(products.getOrders().getId()).get();
				products.setOrders(o);
		}
		return productRepository.save(products);
		
	}

	@Override
	public Products updateproduct(int id, Products products) {
		Products p=productRepository.findById(id).get();
		p.setPname(products.getPname());
		p.setPrice(products.getPrice());
		return productRepository.save(p);
	}

	@Override
	public Long findproductcountbyname(String name) {
		return productRepository.countByProductName(name);
	}
	
	
	
}
