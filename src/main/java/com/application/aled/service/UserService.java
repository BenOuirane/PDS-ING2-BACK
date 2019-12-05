package com.application.aled.service;

import com.application.aled.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* Here we have an interface with all of the methods that will
* be implemented on our UserService
 */
@Service
public interface UserService {

    public List<User> getUsers();

    public User userLogin(String username, String password);

}
