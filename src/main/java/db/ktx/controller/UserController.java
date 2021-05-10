package db.ktx.controller;

import db.ktx.entity.User;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import db.ktx.repository.UserRepository;
import db.ktx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserRepository repository;

	@PostMapping("/createUser")
	public String createUser (@Validated @RequestBody User user){
		return service.insertUser(user);
	}

	@GetMapping("/user")
	public List<User> getUsers(){
		return service.getUsers();
	}

	@GetMapping(path = "{userid}")
	public Optional<User> getUserById (@PathVariable("userid") Long id){
		return service.getUserById(id);
	}

//	@GetMapping(path = "{username}")
//	public Optional<User> getUserByUsername (@PathVariable("username") String username){
//		return service.getUserByUsername(username);
//	}

	@PutMapping("/update")
	public User updateUser (@RequestBody User user){
		return service.updateUser(user);
	}

	@PutMapping("/updatePassword")
	public User updatePassword(@RequestBody User passUser){
		return service.updatePassword(passUser);
	}

//	@DeleteMapping(path = "{username}")
//	public String deleteByUsername(@PathVariable("username") String username){
//		return service.deleteUserByUsername(username);
//	}
	@DeleteMapping(path = "{userid}")
	@ResponseBody
	public String deleteById(@PathVariable("userid") Long id){
		service.deleteUserById(id);
		return "Successfully";
	}

}
