//package db.ktx.service;
//
//import db.ktx.entity.User;
//import db.ktx.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//	@Autowired
//	private UserRepository repository;
//
//	public User insertUser (User user){
//		return repository.save(user);
//	}
//
//	public List<User> insertUsers(List<User> users){
//		return repository.saveAll(users);
//	}
//
//	public List<User> getUsers(){
//		return repository.findAll();
//	}
//
//	public Optional<User> getUserById(int id){
//		return repository.findById(id);
//	}
//
//	public User getUserByUsername(String username){
//		return repository.findByUsername(username);
//	}
//	public User updateUser(User updateUser){
//		User baseUser = repository.findById(updateUser.getUserId()).orElse(null);
//		baseUser.setUsername(updateUser.getUsername());
//		baseUser.setAge(updateUser.getAge());
//		baseUser.setEmail(updateUser.getEmail());
//		baseUser.setUpdate_at(new Date());
//		return repository.save(baseUser);
//	}
//
//}
