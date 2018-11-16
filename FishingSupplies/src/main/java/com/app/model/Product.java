package com.app.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
public class Product implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	Long id;
	
	@NotBlank(message = "{product.not.blank}")
    String product;
	
    String brand;
    String category;
    
    @Min(value = 1, message = "{price.min}")
    double price;
    
    public void setId(Long uuid) {
        this.id = uuid;
    }
    public Long getId() {
        return this.id;
    }
    
    public void setProduct(String prod) {
        this.product = prod;
    }
    public String getProduct() {
        return this.product;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }
  
}

