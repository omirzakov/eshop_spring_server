package com.csse.restapi.restapireact.rest;

import com.csse.restapi.restapireact.entities.Users;
import com.csse.restapi.restapireact.security.jwt.JwtProvider;
import com.csse.restapi.restapireact.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;


    @PostMapping("/register")
    public String registerUser(@RequestBody Users user) {
        System.out.println(user.getPassword());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping(value = "/auth")
    public AuthResponse auth(@RequestBody Users users) {
        System.out.println(users.getEmail());
        Users user = userService.findByLoginAndPassword(users.getEmail(), users.getPassword());
        System.out.println(user);
        System.out.println(users);
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    @PostMapping(value = "/validate/token/{token}")
    public ResponseEntity<?> validateToken(@PathVariable String token) {
        boolean isAuth = jwtProvider.validateToken(token);

        return ResponseEntity.ok(isAuth);
    }

    @PostMapping(value = "/getprofile/{token}")
    public ResponseEntity<?> getProfile(@PathVariable String token) {
        System.out.println(token);

        String email = jwtProvider.getLoginFromToken(token);
        Users currentUser = null;

        if(email != null && email.length() > 0) {
            currentUser = userService.findByLogin(email);
        }

        System.out.println(currentUser);
        return ResponseEntity.ok(currentUser);
    }

    @PostMapping(value = "/updatename/{token}/{fullname}")
    public ResponseEntity<?> updateFullname(@PathVariable String token, @PathVariable String fullname) {
        Users user = null;

        if(jwtProvider.validateToken(token)) {
            String email = jwtProvider.getLoginFromToken(token);

            user = userService.updateFullname(email, fullname);
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/updatepassword/{token}/{old}/{newPass}")
    public ResponseEntity<?> updatePassword(@PathVariable String token,
                                            @PathVariable String old,
                                            @PathVariable String newPass) {
        Users user = null;

        if (jwtProvider.validateToken(token)) {
            String email = jwtProvider.getLoginFromToken(token);
            user = userService.findByLogin(email);

            if(userService.checkPassword(user, old)) {
                userService.updatePassword(user, newPass);

                return ResponseEntity.ok(user);
            }

            return (ResponseEntity<?>) ResponseEntity.status(401);

        }


        return ResponseEntity.ok(user);
    }

}
