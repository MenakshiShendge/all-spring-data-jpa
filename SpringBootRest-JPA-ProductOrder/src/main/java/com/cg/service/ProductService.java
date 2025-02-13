package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Products;
import com.cg.repository.ProductRepository;
@Service
public class ProductService implements IProductService {
    
	List<Products> productList = new ArrayList();
    @Autowired
    ProductRepository productRepository;
	
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
		return productRepository.save(products);
		
	}

	@Override
	public Products updateproduct(int id, Products products) {
		Products p=productRepository.findById(id).get();
		p.setPname(products.getPname());
		p.setPrice(products.getPrice());
		return productRepository.save(p);
	}
	
	
	
}
