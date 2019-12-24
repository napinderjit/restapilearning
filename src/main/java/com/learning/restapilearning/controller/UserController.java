package com.learning.restapilearning.controller;

import com.learning.restapilearning.model.User;
import com.learning.restapilearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userService.findAll();
        if(!users.isEmpty()){
            return ResponseEntity.ok().body(users);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User u = userService.save(user);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri()).body(u);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        if(user!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users")
    public ResponseEntity<User> update(@RequestBody User user){
        User u = userService.updateUser(user);
        if(u != null)
            return ResponseEntity.ok().body(u);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        User user = userService.deleteById(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
