package db.ktx.service;

import db.ktx.entity.User;
import db.ktx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService{
	@Autowired
	private UserRepository repository;

	public String insertUser (User user){
		List<User> lisdUser = repository.findAll();
		for (User user1 : lisdUser){
			if(user1.getUsername().equalsIgnoreCase(user.getUsername())){
				return "Nguoi dung da ton tai";
			}
		}
		repository.save(user);
		return "Them thanh cong";
	}

	public List<User> getUsers(){
		return repository.findAll();
	}

	public Optional<User> getUserById(Long id){
		return repository.findById(id);
	}

	public Optional<User> getUserByUsername(String username){
		return repository.findByUsername(username);
	}
	public User updateUser(User updateUser){
		User baseUser = repository.findById(updateUser.getUserid()).orElse(null);
		baseUser.setEmail(updateUser.getEmail());
		baseUser.setName(updateUser.getName());
		baseUser.setAge(updateUser.getAge());
		baseUser.setPhone(updateUser.getPhone());
		baseUser.setAddress(updateUser.getAddress());
		return repository.save(baseUser);
	}
	//Doi mat khau
	public User updatePassword(User password){
		User passUser = repository.findById(password.getUserid()).orElse(null);
		passUser.setPassword(password.getPassword());
		return  repository.save(passUser);
	}

	//delete UserbyUsername
	public String deleteUserByUsername(String username){
		try{
			repository.deleteByUsername(username);
		}catch (Exception e){
			e.getMessage();
			return "false";
		}
		return "true";
	}
	//DeleteUserById
	public void deleteUserById(Long id) {
		repository.deleteById(id);
	}

}
