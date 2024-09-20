package com.project.user.convert;

import com.project.user.dto.UserDto;
import com.project.user.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convertor {
    public UserDto ToDto(User user){
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName());
    }

    public User ToEntity(UserDto dto){
        return User.builder()
                .id(dto.id())
                .username(dto.username())
                .password(dto.password())
                .email(dto.email())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .build();
    }

    public List<UserDto> ToDto(List<User> users){
        List<UserDto> dtos = new ArrayList<>();
        for(User user : users){
            UserDto userDto = ToDto(user);
            dtos.add(userDto);
        }
        return dtos;
    }
}
