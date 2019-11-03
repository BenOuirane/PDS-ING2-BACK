package com.application.aled.service;

import com.application.aled.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getUsers();

}
