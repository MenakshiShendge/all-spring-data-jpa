package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Products;

import jakarta.persistence.EntityNotFoundException;

public interface IProductService {
   public List<Products> findAllProduct();
   public Optional<Products> findproductbyid(int id) throws EntityNotFoundException;
   public List<Products> findproductbyname(String name);
   public void deleteproductbyid(int id);
   public Products newproduct(Products products);
   public Products updateproduct(int id,Products products);
   public Long findproductcountbyname(String name);
   
}
