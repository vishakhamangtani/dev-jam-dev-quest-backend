package com.devjam.mysmartprice.service;

import com.devjam.mysmartprice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service

public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Map<String,Object>> fetchProducts(){
        return productRepository.fetchProducts();
    }
    public List<Map<String,Object>> fetchProducts(int category_id){
        return productRepository.fetchProducts(category_id);
    }
    public List<Map<String,Object>> fetchCategory(){
        return productRepository.fetchCategory();
    }
    public List<Map<String,Object>> fetchWishlist(int u_id){
        return productRepository.fetchWishlist(u_id);
    }
    public ResponseEntity<String> insertWishlist(Map<String,Object> body){
        int authorId=(int) body.get("authorId");
        String title=(String) body.get("title");
        String imageUrl=(String) body.get("imageUrl");
        String description=(String) body.get("description");
        int category=(int) body.get("category");
        String tags=(String) body.get("tags");
        // System.out.println(authorId+" "+title+" "+imageUrl+" "+description+" "+category);
        int noOfRows=productRepository.insertWishlist(authorId,title,description,imageUrl,category,tags);
        if(noOfRows>0){
            return ResponseEntity.ok("Successfully added to wishlist");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Addition Failed");

    }
    public List<Map<String,Object>> removeWishlist(int u_id,int product_id){
        return productRepository.removeWishlist(u_id,product_id);
    }
}


