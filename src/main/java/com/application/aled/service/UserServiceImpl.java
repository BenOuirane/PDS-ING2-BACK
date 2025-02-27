
package com.application.aled.service;

import com.application.aled.entity.User;
import com.application.aled.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    /*
    We get a UserRepository attribute so we get all basic
    sql methods (findAll(), save()...)
    They will be our base for the rest of the service
     */
    @Autowired
    private UserRepository repository;

    Logger logger = Logger.getLogger("com.application.aled.service.UserRepository");

    /*
    Here we use the 'findAll()' to create a custom getUsers()
    for our application, our controllers
     */
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        repository.findAll().forEach(users::add);

        return users;
    }

    @Override
    public User userLogin(String username, String password) throws NullPointerException {
        logger.info("Login user " + username + " and password " + password);

        User user = repository.findByUsernameAndPassword(username, password);

        return user;
    }

    @Override
    public List<User> getUserByRole(String role) {
        logger.info("Finding users with role : " + role);

        List<User> users = new ArrayList<>();
        repository.findAllByRole(role).forEach(users::add);

        return users;
    }

    @Override
    public User getUserById(long id) {
        User user = new User();
        user = repository.findById(id);
        return user;
    }

}
