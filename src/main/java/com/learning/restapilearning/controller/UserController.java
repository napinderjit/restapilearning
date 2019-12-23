package com.learning.restapilearning.controller;

import com.learning.restapilearning.model.User;
import com.learning.restapilearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
