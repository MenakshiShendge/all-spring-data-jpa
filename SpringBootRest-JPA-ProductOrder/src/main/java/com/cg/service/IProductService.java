package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Products;

public interface IProductService {
   public List<Products> findAllProduct();
   public Optional<Products> findproductbyid(int id);
   public List<Products> findproductbyname(String name);
   public void deleteproductbyid(int id);
   public Products newproduct(Products products);
   public Products updateproduct(int id,Products products);
   
}
