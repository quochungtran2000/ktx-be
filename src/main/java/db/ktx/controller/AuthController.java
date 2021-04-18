package db.ktx.controller;

import db.ktx.ERole;
import db.ktx.JavaWebToken.JwtUtils;
import db.ktx.JavaWebToken.UserDetailsImpl;
import db.ktx.Payload.JwtResponse;
import db.ktx.Payload.LoginRequest;
import db.ktx.Payload.MessageResponse;
import db.ktx.Payload.SigupRequest;
import db.ktx.entity.Role;
import db.ktx.entity.User;
import db.ktx.repository.RoleRepository;
import db.ktx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.Encoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername()
                ,loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return  ResponseEntity.ok(new JwtResponse(jwt,userDetails.getId(), userDetails.getUsername(), roles));

    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SigupRequest sigupRequest){
        if(userRepository.existByUsername(sigupRequest.getUsername())){
            return ResponseEntity
                    .badRequest().body(new MessageResponse("error:Username is already taken!"));
        }
        //Create new user's account
        User user = new User(sigupRequest.getUsername(),
                sigupRequest.getPassword());
        Set<String> strRoles = sigupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if(strRoles == null){
            Role userRole = roleRepository.findByName(ERole.ROLE_USER);
            if(userRole == null){
                throw new RuntimeException("Error:Role is not found");
            }
            roles.add(userRole);
        }
        else {
            strRoles.forEach(role ->{
                switch (role){
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
                        if(adminRole == null){
                            throw new RuntimeException("Error:Role is not found");
                        }
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER);
                        if(userRole == null){
                            throw new RuntimeException("Error:Role is not found");
                        }
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User resigntered successfully!"));
    }

}
