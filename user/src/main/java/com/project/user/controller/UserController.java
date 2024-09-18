package com.project.user.controller;

import com.project.user.convert.Convertor;
import com.project.user.dto.LoginRequestDto;
import com.project.user.dto.UserDto;
import com.project.user.model.User;
import com.project.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private Convertor convertor;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        User new_user = userService.registerUser(convertor.ToEntity(userDto));
        return new ResponseEntity<>(convertor.ToDto(new_user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable int id) {
        if(userService.getUserById(id).isPresent()) {
            return new ResponseEntity<>(convertor.ToDto(userService.getUserById(id).get()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(userService.login(loginRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(convertor.ToDto(userService.getAllUsers()), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int id , @RequestBody UserDto userDto) {
        return new ResponseEntity<>(convertor.ToDto(userService.updateUser(id, convertor.ToEntity(userDto))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully" , HttpStatus.OK);
    }
}