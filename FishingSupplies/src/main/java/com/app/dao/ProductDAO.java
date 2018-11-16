package com.app.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.app.model.Product;

public interface ProductDAO extends JpaRepository<Product, Long> {
	
	Page<Product> findByCategory(String category, Pageable page);
	
}
