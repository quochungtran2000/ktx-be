package db.ktx.controller;

//import db.ktx.entity.Role;
import db.ktx.entity.Role;
import db.ktx.entity.Roles;
import db.ktx.entity.User;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

import db.ktx.jwt.configs.MyUserDetailsService;
import db.ktx.jwt.models.AuthenticationResponse;
import db.ktx.jwt.models.SignupRequest;
import db.ktx.jwt.util.JwtUtil;
//import db.ktx.repository.RoleRepository;
import db.ktx.repository.RoleRepository;
import db.ktx.repository.UserRepository;
import db.ktx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MyUserDetailsService userDetailsService;


	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping("/signup")
	public ResponseEntity<?> createUser(@RequestBody  SignupRequest signupRequest){
		User user = new User(
				signupRequest.getUsername(),
				signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()),
				signupRequest.getName(),
				signupRequest.getAge(),
				signupRequest.getPhone(),
				signupRequest.getImg_url());

		Set<String> stringroles = signupRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if(stringroles ==  null){
			Role userRole = roleRepository.findByName(Roles.USER);
			if(userRole == null) {
				throw new RuntimeException("Error: Role is not found ");
			}
			roles.add(userRole);
		}
		else{
			Role adminRole= roleRepository.findByName(Roles.ADMIN);
			if(adminRole == null){
				throw new RuntimeException("Error : Role is not found");
			}
			roles.add(adminRole);
		}
		user.setRoles(roles);
		service.insertUser(user);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(user.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(token));
	}


	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public User getUser (HttpServletRequest request) {
//		return (int) request.getAttribute("userID");
		System.out.print(request);
		Principal principal = request.getUserPrincipal();

		return service.getUserByUsername(principal.getName());
	}


	@GetMapping()
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

	@GetMapping("/{userid}")
	public Optional<User> getUserById (@PathVariable("userid") Long id){
		return service.getUserById(id);
	}

//	@GetMapping(path = "{username}")
//	public Optional<User> getUserByUsername (@PathVariable("username") String username){
//		return service.getUserByUsername(username);
//	}

	@PutMapping()
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
	@DeleteMapping("/{userid}")
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
