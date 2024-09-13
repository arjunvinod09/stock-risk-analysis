package com.project.user.service;

import com.project.user.exception.UserNotFound;
import com.project.user.model.LoginRequest;
import com.project.user.model.User;
import com.project.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        user.setRegistrationDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }


    @Override
    public User updateUser(String id, User user) {
        var current = userRepository.findById(id);
        if(current.isPresent()){
            User newUser = current.get();
            newUser = User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .dob(user.getDob())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .profilePic(user.getProfilePic())
                    .build();
            return userRepository.save(user);
        }
        else{
            throw new UserNotFound("No such user exists");
        }
    }

    @Override
    public void deleteUser(String id) {
        userRepository
                .findById(id)
                .ifPresent(user -> userRepository.delete(user));

    }

    @Override
    public String login(LoginRequest loginRequest) {
        log.info("Login request: {}", loginRequest);
        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new UserNotFound("Try logging in with valid credentials"));
        if(user.getPassword().equals(loginRequest.getPassword())){
            return "User Logged in successfully";
        }
        else{
            return "Wrong email or password";
        }
    }
}
