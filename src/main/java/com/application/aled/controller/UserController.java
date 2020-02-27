package com.application.aled.controller;

import java.util.List;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.service.UserServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.application.aled.entity.User;
import com.application.aled.repository.UserRepository;


/*
 * Annotation Cross Origins :
 * CrossOrigin allows an external domain to access
 * our data, our web pages
 * 
 * Here, as we put '*', we agree that every 
 * domain access our pages
 */

/*
 * Annotation Request Mapping :
 * RequestMapping gives us the base element of our routes :
 * Here, we have http://{localhost} or {172.31.254.61}/api/...
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
	static final Logger logger = LogManager.getLogger(UserController.class.getName());

	@Autowired
	UserRepository repository;

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		logger.info("Getting all users  from user table...Call getAllUsers ");
		List<User> users = userService.getUsers();
		logger.info("Data extracted from user table...");
		return users;
	}

	@PostMapping(value = "/users/create")
	public User postUser(@RequestBody User user) {
		User _user = repository.save(new User(user.getUsername(), user.getPassword(), user.getRole()));

		return _user;
	}

	@PutMapping(value = "/user/login")
	public User loginUser(@RequestBody User user) throws Exception {
		logger.info("Getting all users  from user table...Call getAllUsers ");
		User _user = userService.userLogin(user.getUsername(), user.getPassword());
		logger.info("Extracting data from the user table");

		if(_user == null){
			logger.error("Getting all users  from user table...Call getAllUsers ");
			throw new CustomHandler("User not found");

		} else {
			logger.info("Getting all users  from user table...Call getAllUsers ");

			return _user;
		}
	}

	@PutMapping(value = "/users/")
	public List<User> getUsersByRole(@RequestBody String role) {
		logger.info("Getting all users  from user table...Call getAllUsers ");
		List<User> users = userService.getUserByRole(role);
		logger.info("Extracting data from the user table");
		return users;
	}

}

