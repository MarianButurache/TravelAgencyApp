package com.travel.services;

import com.travel.entities.Role;
import com.travel.entities.RoleTypes;
import com.travel.entities.User;
import com.travel.repositories.RoleRepository;
import com.travel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        //parola in plain text pe care o trimite utilizatorul
        String initialPassword = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(initialPassword);
        user.setPassword(encodedPassword);
        if (user.getRole() == null){
            // gasim rolul in db
            Role userRole = roleRepository.findRoleByName(RoleTypes.USER);
            // setam rolul utilizatorului
            user.setRole(userRole);
        }
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        User userFromDatabase = userRepository.findByUsername(username);
        return userFromDatabase;
    }

}


