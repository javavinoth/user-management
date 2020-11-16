package com.mycommunityapp.usermanagement.service;

import com.mycommunityapp.usermanagement.model.User;
import com.mycommunityapp.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String createUser(User user) {
        User savedUser = userRepository.save(user);
        return (savedUser != null) ? savedUser.getId() : "";

    }

    public User readUser(String id) {
        Optional<User> user = userRepository.findById(id);
        return (user.isPresent()) ? user.get() : null;
    }
}
