package com.cg.dto;

import com.cg.entity.Products;

public class ProductDTO {
	 
    private int id;
    private String pname;
    private double price;
 
    public ProductDTO() {}
 
    public ProductDTO(int id, String pname, double price) {
        this.id = id;
        this.pname = pname;
        this.price = price;
    }
 
    // Getters and Setters
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getPname() {
        return pname;
    }
 
    public void setPname(String pname) {
        this.pname = pname;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    // Optionally, you can add methods to convert from Entity to DTO and vice versa.
    public static ProductDTO fromEntity(Products product) {
        return new ProductDTO(product.getId(), product.getPname(), product.getPrice());
    }
 
    public Products toEntity() {
        return new Products(this.id, this.pname, this.price);
    }
}
