package com.devjam.mysmartprice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> fetchProducts(){
        return jdbcTemplate.queryForList("EXEC medium.fetch_products");
    }
    public List<Map<String,Object>> fetchProducts(int category_id){
        return jdbcTemplate.queryForList("EXEC medium.fetch_all_products ?",category_id);
    }
    public List<Map<String,Object>> fetchCategory(){
        return jdbcTemplate.queryForList("EXEC medium.fetch_all_categories ?");
    }
    public List<Map<String,Object>> fetchWishlist(int u_id){
        return jdbcTemplate.queryForList("EXEC medium.fetch_all_categories ?",u_id);
    }
    public int insertWishlist(int authorId,String title,String description,String imageUrl,int category,String tags){
        return jdbcTemplate.update("EXEC medium.sp_insert_blog ?, ?, ?, ?, ?,?",authorId,title,description,category
                ,imageUrl,tags);
    }
    public List<Map<String,Object>> removeWishlist(int u_id,int product_id){
        return jdbcTemplate.queryForList("EXEC medium.fetch_all_categories ?,?",u_id,product_id);
    }

}


