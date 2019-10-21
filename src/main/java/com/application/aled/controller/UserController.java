package com.application.aled.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.aled.entity.User;
import com.application.aled.repository.UserRepository;
 
 
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
 
  @Autowired
  UserRepository repository;
 
  @GetMapping("/users")
  public List<User> getAllUsers() {
    System.out.println("Get all Users...");
 
    List<User> users = new ArrayList<>();
    repository.findAll().forEach(users::add);
 
    return users;
  }
 
  @PostMapping(value = "/users/create")
  public User postUser(@RequestBody User user) {
 
    User _user = repository.save(new User(user.getFirstname(), user.getLastname()));
    return _user;
  }
 
}
