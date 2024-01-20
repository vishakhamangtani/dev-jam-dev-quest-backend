package com.devjam.mysmartprice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addUser(String u_name,String email,String password)
    {
        return jdbcTemplate.update("EXEC sp_add_user ?,?,?",u_name,email,password);
    }
    public int getUser(String username,String password)
    {
        return jdbcTemplate.queryForObject("EXEC sp_validate_user ?,?",Integer.class,username,password);
    }


}
