package db.ktx.controller;

import db.ktx.entity.User;
import java.util.List;
import java.util.Optional;

import db.ktx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/createUser")
	public User createUser (@RequestBody User user){
		return service.insertUser(user);
	}
	
	@PostMapping("/createUsers")
	public List<User> craeteUsers(@RequestBody List<User> users){
		return service.insertUsers(users);
	}
	
	@GetMapping("/user")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById (@PathVariable int id){
		return service.getUserById(id);
	}
	
	@GetMapping("/user/{username}")
	public User getUserByUsername (@PathVariable String username){
		return service.getUserByUsername(username);
	}
	
	@PutMapping("/update")
	public User updateUser (@RequestBody User user){
		return service.updateUser(user);
	}

	@PutMapping("/updatepassword")
	public User updatePassword(@RequestBody User user){
		return service.updatePassword(user);
	}
	
}
