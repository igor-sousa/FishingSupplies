package com.app.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.ProductDAO;
import com.app.model.Product;

/**
 * Adapter da API
 */

@RestController
@RequestMapping("/fishingproducts/v1")
public class ProductController {
   
  @Autowired
  private ProductDAO prod;
  
  @GetMapping("/{category}")
  public Page<Product> searchCategory( @PathVariable String category, 
		  @RequestParam(defaultValue = "10") int pageSize,
		  @RequestParam(defaultValue = "0") int page, 
		  @RequestParam(defaultValue = "product") String order,
		  @RequestParam(defaultValue = "ASC") Sort.Direction direction) {
    return prod.findByCategory(category,new PageRequest(page, pageSize, new Sort(direction, order)));
  }
 
  @GetMapping
  public Page<Product> consultAll(
		  @RequestParam(defaultValue = "10") int pageSize,
		  @RequestParam(defaultValue = "0") int page, 
		  @RequestParam(defaultValue = "product") String order,
		  @RequestParam(defaultValue = "ASC") Sort.Direction direction) {
    return prod.findAll(new PageRequest(page, pageSize, new Sort(direction, order)));
  }		
   
  @PostMapping
  public Product save(@RequestBody @Valid Product p) {
    return prod.save(p);
  }
 
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    prod.deleteById(id);
  }
 
}
