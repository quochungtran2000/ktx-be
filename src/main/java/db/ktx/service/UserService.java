package db.ktx.service;

import db.ktx.JavaWebToken.UserDetailsImpl;
import db.ktx.entity.User;
import db.ktx.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	
	public User insertUser (User user){
		return repository.save(user);
	}
	
	public List<User> insertUsers(List<User> users){
		return repository.saveAll(users);
	}
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public Optional<User> getUserById(int id){
		return repository.findById(id);
	}
	
	public User getUserByUsername(String username){
		return repository.findByUsername(username);
	}
	public User updateUser(User updateUser){
		User baseUser = repository.findById(updateUser.getUserId()).orElse(null);
		baseUser.setUsername(updateUser.getUsername());
		baseUser.setAge(updateUser.getAge());
		baseUser.setEmail(updateUser.getEmail());
		baseUser.setUpdate_at(new Date());
		return repository.save(baseUser);
	}
	//Update password
	public User updatePassword(User user){
		User baseUser = repository.findById(user.getUserId()).orElse(null);
		baseUser.setPassword(user.getReset_password());
		return repository.save(baseUser);
	}
	//Delete User
	public User deleteUser(User user){
		User baseUser = repository.findByUsername(user.getUsername());
		if(baseUser != null){
			repository.delete(baseUser);
		}
		return repository.save(user);
	}
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = repository.findByUsername(username);
		if(user == null){
				throw new UsernameNotFoundException(username);
		}
		return UserDetailsImpl.build(user);
	}
	
}
