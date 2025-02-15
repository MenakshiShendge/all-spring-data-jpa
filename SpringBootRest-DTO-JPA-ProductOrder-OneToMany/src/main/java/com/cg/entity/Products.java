package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="productsOneToManyJPA")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private  int id;
	@Column(name="pname", nullable =false)
 private  String pname;
	@Column(name="price", nullable = false)
 private  double price;
public Products() {
	this.id = 0;
	this.pname = "";
	this.price = 0.0;
}
public Products(int id, String pname, double price) {
	super();
	this.id = id;
	this.pname = pname;
	this.price = price;
}
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
@Override
public String toString() {
	return "Product [id=" + id + ", pname=" + pname + ", price=" + price + "]";
}
 
 
}
