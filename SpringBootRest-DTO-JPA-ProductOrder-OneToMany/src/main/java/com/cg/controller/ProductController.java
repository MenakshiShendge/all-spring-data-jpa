package com.cg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.ProductDTO;
import com.cg.entity.Products;
import com.cg.exception.ResourceNotFoundException;
import com.cg.service.ProductService; 

@RestController
@RequestMapping("/papi")
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/hello")
 public String getHello() {
	 return "Hello Spring Rest";
 }
	@GetMapping(path = "/productsjpa", produces = {MediaType.APPLICATION_JSON_VALUE})
	
//	@GetMapping("/products")
	public List<Products> getAllProducts(){
		return productService.findAllProduct();
	}
	
	@GetMapping("/products/{id}")
	public Products getproductbyid(@PathVariable int id) throws ResourceNotFoundException  {
		return productService.findproductbyid(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
	}
	///products/{id} and /products/{pname} creates ambiguity 
	//to avoid ambiguity way 1
	@GetMapping("/product/{pname}")
	public List<ProductDTO> getproductbyname(@PathVariable String pname) {
		List<Products> products=productService.findproductbyname(pname);
		List<ProductDTO> productDTOs = products.stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
		return productDTOs;
		
	}
	
	//to avoid ambiguity way 2
	@GetMapping("/products/name/{pname}")
	public List<Products> getproductbyname1(@PathVariable String pname) {
		return productService.findproductbyname(pname);
	}
	
	//http://localhost:8080/papi/products?name=kurkure
//	@GetMapping("/products")
//	public List<Products> getproductbyname2(@RequestParam String name){
//		return productService.findproductbyname(name);
//	}
	
	@DeleteMapping("/products/{id}")
	public void deleteproduct(@PathVariable int id) {
		productService.deleteproductbyid(id);
	}
	//done
	@PostMapping("/products")
	public Products createproduct(@RequestBody Products products) {
		Products p=productService.newproduct(products);
		System.out.println(p);
		return p;
	}
	
	@PutMapping("/products/{id}")
	public Products updateproduct(@PathVariable int id,@RequestBody Products products) {
		return productService.updateproduct(id, products);
	}
	
	@GetMapping("/count/{pname}")
	public Long getproductcountbyname(@PathVariable String pname) {
		return productService.findproductcountbyname(pname);
	}
	//implement conversion DTO to entity during post.
	@PostMapping("/productsdto")
	public ProductDTO createproductusingdto(@RequestBody ProductDTO productDTO) {
		Products p1=productDTO.toEntity();
		Products p=productService.newproduct(p1);
		
		return productDTO.fromEntity(p);
	}
}
