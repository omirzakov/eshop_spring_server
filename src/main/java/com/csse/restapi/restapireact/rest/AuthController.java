package com.csse.restapi.restapireact.rest;

import com.csse.restapi.restapireact.entities.Users;
import com.csse.restapi.restapireact.security.jwt.JwtProvider;
import com.csse.restapi.restapireact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/register")
    public String registerUser(@RequestBody Users user) {
        Users u = new Users();
        u.setPassword(user.getPassword());
        u.setPassword(user.getEmail());
        userService.saveUser(u);
        return "OK";
    }

    @PostMapping(value = "/auth")
    public AuthResponse auth(@RequestBody Users users) {
        Users user = userService.findByLoginAndPassword(users.getEmail(), users.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

}
