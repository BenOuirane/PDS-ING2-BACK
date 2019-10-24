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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository repository;


	/*
	 * Annotation GetMapping :
	 * GetMapping gives us the route to get to the getAllUsers() function :
	 * Here, we have http://{localhost} or {172.31.254.61}/api/users
	 */
	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("Get all Users...");

		List<User> users = new ArrayList<>();
		repository.findAll().forEach(users::add);

		return users;
	}

	/*
	 * Annotation @PostMapping :
	 * @PostMapping gives us the route to get to the postUser() function :
	 * Here, we have http://{localhost} or {172.31.254.61}/api/users/create
	 */

	/*
	 * Annotation @RequestBody :
	 * With this annotation, we say that our request (from the 
	 * fronend app) will have a user in his body
	 * and that it will be our parameter for this function
	 */
	@PostMapping(value = "/users/create")
	public User postUser(@RequestBody User user) {
		System.out.println("Adding a user...");

		User _user = repository.save(new User(user.getFirstname(), user.getLastname()));

		return _user;
	}

}
