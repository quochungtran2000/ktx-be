package db.ktx.controller;

import db.ktx.entity.User;
import db.ktx.repository.UserRepository;
import db.ktx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

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


	@GetMapping("/getUser")
	public User getUser (HttpServletRequest request) {
//		return (int) request.getAttribute("userID");
		System.out.print(request);
		Principal principal = request.getUserPrincipal();

		return service.getUserByUsername(principal.getName());
	}

	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<?> getUsers(
			@RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "12") int size){
			try {
				List<User> users = new ArrayList<User>();
				Pageable pageable = PageRequest.of(page -1, size);

				Page<User> pageTuts;
				pageTuts = repository.findUser(pageable);

				users = pageTuts.getContent();

				Map<String, Object> response = new HashMap<>();
				response.put("users", users);
				response.put("currentPage", pageTuts.getNumber());
				response.put("totalItems", pageTuts.getTotalElements());
				response.put("totalPages", pageTuts.getTotalPages());

				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
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

	@GetMapping("/login")
	public List<User> login(User user){
		return service.getUsers();
	}

}
