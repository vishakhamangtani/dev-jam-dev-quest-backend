package com.devjam.mysmartprice.service;

import com.devjam.mysmartprice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<String> addUser(@RequestBody Map<String, Object> body) {

        String u_name = (String) body.get("u_name");
        String email = (String) body.get("email");
        String password = (String) body.get("password");


        int rowsAffected = userRepository.addUser(u_name,email,password);
        if (rowsAffected > 0) {
            return ResponseEntity.ok("User is registered");
        }

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Registration Failed");

    }

    public String getUser(Map<String, Object> body) {

        String username = (String) body.get("username");
        String password = (String) body.get("password");
        int status = userRepository.getUser(username, password);
        if (status == 0) {
            return "User not found Invalid username or password";
        } else {
            return "User found";
        }

    }
}