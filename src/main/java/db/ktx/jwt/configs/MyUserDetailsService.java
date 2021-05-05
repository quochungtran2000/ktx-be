package db.ktx.jwt.configs;


import db.ktx.entity.User;
import db.ktx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = new User();
//        Optional<User> user = repository.findByUsername(username);
//        return  user.map(MyUserDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException(username + "Not Found"));
        User user = repository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username +"Not Found"));

        return new MyUserDetails(user);
    }
}
