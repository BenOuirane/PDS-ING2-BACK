package com.application.aled.controller;

import java.util.List;

import com.application.aled.controller.exception.CustomHandler;
import com.application.aled.service.UserServiceImpl;
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

	@Autowired
	UserRepository repository;

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("Call getAllUsers");

		List<User> users = userService.getUsers();

		return users;
	}

	@PostMapping(value = "/users/create")
	public User postUser(@RequestBody User user) {
		User _user = repository.save(new User(user.getFirstname(), user.getLastname(), user.getUsername(), user.getPassword(), user.getRole()));

		return _user;
	}

	@PutMapping(value = "/user/login")
	public User loginUser(@RequestBody User user) throws Exception {
		System.out.println("Call loginUser");

		User _user = userService.userLogin(user.getUsername(), user.getPassword());

		if(_user == null){
			throw new CustomHandler("User not found");
		} else {
			return _user;
		}
	}

	@PutMapping(value = "/users/")
	public List<User> getUsersByRole(@RequestBody String role) {
		System.out.println("Call getResidents");

		List<User> users = userService.getUserByRole(role);

		return users;
	}

}
