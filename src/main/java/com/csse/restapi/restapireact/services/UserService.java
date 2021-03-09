package com.csse.restapi.restapireact.services;

import com.csse.restapi.restapireact.entities.Roles;
import com.csse.restapi.restapireact.entities.Users;
import com.csse.restapi.restapireact.repositories.RoleRepository;
import com.csse.restapi.restapireact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users saveUser(Users user) {
        Roles userRole = roleRepository.findByName("ROLE_USER");
        List<Roles> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Users findByLogin(String email) {
        return userRepository.findByEmail(email);
    }

    public Users findByLoginAndPassword(String login, String password) {
        Users userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }


}
