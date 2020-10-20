package com.nick.example.graphql_example_kickstart.service;

import com.nick.example.graphql_example_kickstart.entity.User;
import com.nick.example.graphql_example_kickstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user){
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null){
            return existingUser;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
}
