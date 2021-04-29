//package db.ktx.controller;
//
//import db.ktx.jwt.JwtTokenProvider;
//import db.ktx.payload.LoginRequest;
//import db.ktx.payload.LoginResponse;
//import db.ktx.payload.RandomStuff;
//import db.ktx.service.MyUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//@RestController
//@RequestMapping
//public class AuthController {
//
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider tokenProvider;
//
//    @PostMapping("/login")
//    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        // Xác thực thông tin người dùng Request lên
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        // Nếu không xảy ra exception tức là thông tin hợp lệ
//        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Trả về jwt cho người dùng.
//        String jwt = tokenProvider.generateToken((MyUserDetails) authentication.getPrincipal());
//        return new LoginResponse(jwt);
//    }
//
//    // Api /api/random yêu cầu phải xác thực mới có thể request
//    @GetMapping("/random")
//    public RandomStuff randomStuff(){
//        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
//    }
//
//
//}
