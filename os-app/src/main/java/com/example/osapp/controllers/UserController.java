package com.example.osapp.controllers;


import com.example.osapp.model.persistence.repositories.UserRepository;
import com.example.osapp.model.requests.CreateUserRequest;
import com.example.osapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;


	@GetMapping("/id/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		log.debug("UserController.findById called with id {}", id);
		return ResponseEntity.of(userRepository.findById(id));
	}

	@GetMapping("/{username}")
	public ResponseEntity<User> findByUserName(@PathVariable String username) {
		log.debug("UserController.findByUserName called with username {}");
		User user = userRepository.findByUsername(username);
		return user == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(user);
	}

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest) {
		log.debug("UserController.createUser called with username {}", createUserRequest.getUsername());
		if (
				createUserRequest.getPassword().length() <= 6 ||
				!createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())
		) {
			log.error("Cannot create user {} because the password is invalid", createUserRequest.getUsername());
			return ResponseEntity.badRequest().build();
		}
		User user = userService.createUser(createUserRequest.getUsername(), createUserRequest.getPassword());;
		log.info("New user {} created", createUserRequest.getUsername());
		return ResponseEntity.ok(user);
	}

}
