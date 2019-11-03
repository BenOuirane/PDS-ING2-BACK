package com.application.aled.service;

import com.application.aled.entity.User;
import com.application.aled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getUsers() {
        System.out.println("Get all Users...");

        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);

        return users;
    }
}
