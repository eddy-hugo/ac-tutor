package com.demo.actutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.actutor.exception.ResourceNotFoundException;
import com.demo.actutor.model.User;
import com.demo.actutor.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get All Users
    @GetMapping(path="/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // Create a new User
    @PostMapping(path="/add")
    public User addUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
    }
    // Get a Single User
    @GetMapping(path="/{id}")
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }
    // Update a User
    @PutMapping(path="/update/{id}")
    public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));


        user.setName(userDetails.getName());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone()); 

        return  userRepository.save(user);
    }
    // Delete a User
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
