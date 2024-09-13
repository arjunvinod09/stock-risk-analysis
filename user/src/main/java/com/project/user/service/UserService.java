package com.project.user.service;

import com.project.user.model.LoginRequest;
import com.project.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User registerUser(User user);
    public List<User> getAllUsers();
    public Optional<User> getUserById(int id);
    public User updateUser(int id,User user);
    public void deleteUser(int id);
    public String login(LoginRequest loginRequest);
}
