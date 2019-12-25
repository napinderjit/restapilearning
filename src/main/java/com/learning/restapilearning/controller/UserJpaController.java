package com.learning.restapilearning.controller;

import com.learning.restapilearning.model.User;
import com.learning.restapilearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/jpa/users")
    public ResponseEntity<List<User>> findAllUsers(){
         List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            return ResponseEntity.ok().body(users);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User u = userRepository.save(user);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri()).body(u);
    }

    @GetMapping("/jpa/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PutMapping("/jpa/users")
    public ResponseEntity<User> update(@RequestBody User user){
        User u = userRepository.save(user);
        if(u != null)
            return ResponseEntity.ok().body(u);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
