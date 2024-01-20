package com.devjam.mysmartprice.web;

import com.devjam.mysmartprice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductResource {
    @Autowired
    ProductService productService;
    @GetMapping("/product")
    public List<Map<String,Object>> fetchProducts(){
        return productService.fetchProducts();
    }
    @GetMapping("/product/categories/{category_id}")
    public List<Map<String,Object>> fetchProducts(@PathVariable int category_id){
        return productService.fetchProducts(category_id);
    }
    @GetMapping("/categories")
    public List<Map<String,Object>> fetchCategory(){
        return productService.fetchCategory();
    }
    @GetMapping("/wishlist")
    public List<Map<String,Object>> fetchWishlist(@PathVariable int u_id){
        return productService.fetchWishlist(u_id);
    }
    @PostMapping("/wishlist/add")
    public ResponseEntity<String> insertWishlist(@RequestBody Map<String,Object> body){
        return productService.insertWishlist(body);
    }
    @GetMapping("/wishlist/remove")
    public List<Map<String,Object>> removeWishlist(@PathVariable int u_id,int product_id){
        return productService.removeWishlist(u_id,product_id);
    }


}
