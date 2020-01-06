package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserRequest;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    public UserDto checkLogin(String username,String passworld){
        User user= userRepository.findByUserName(username);
        if(user!=null){
            if(user.getPassWorld().equals(passworld)){
                return  userMapper.userToUserDto(user);
            }
        }
        return null;
    }

    public UserDto createUser(CreateUserRequest createUserRequest){
        User user = new User();
        user.setId(userRepository.getIdMax()+1);
        user.setUserName(createUserRequest.getUserName());
        user.setPassWorld(createUserRequest.getPassWorld());
        user.setFullName(createUserRequest.getFullName());
        user.setEmail(createUserRequest.getEmail());
        user.setActive(createUserRequest.isActive());
        user.setPhone(createUserRequest.getPhone());
        Role role= userRepository.findRoleById(createUserRequest.getRole());
        user.setRole(role);
        if(user.getRole()!=null){
            userRepository.save(user);
        }
        user.setPoint(0);
        return userMapper.userToUserDto(user);
    }

}
