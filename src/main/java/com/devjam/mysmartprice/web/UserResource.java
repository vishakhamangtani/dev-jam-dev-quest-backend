package com.devjam.mysmartprice.web;

import com.devjam.mysmartprice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController

public class UserResource {
    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody Map<String,Object> body)
    {
        return userService.addUser(body);
    }
    @PostMapping("/user/login")
    public String getUser(@RequestBody Map<String,Object> body)
    {
        String s = userService.getUser(body);
        return s;
    }


}
