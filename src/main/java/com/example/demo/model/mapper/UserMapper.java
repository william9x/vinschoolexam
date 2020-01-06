package com.example.demo.model.mapper;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private UserRepository userRepository;
    public UserDto userToUserDto(User user){
        UserDto userDto=null;
        if(user!=null){
        userDto= new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName((user.getFullName()));
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setActive(user.isActive());
        userDto.setRole(user.getRole().getName());
        }
        return userDto;
    }
}
