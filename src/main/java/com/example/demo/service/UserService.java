package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

//    public UserDto checkLogin(LoginRequest loginRequest){
//        User user= userRepository.findByUsername(loginRequest.getUserName());
//        if(user!=null){
//            if(user.getPassWorld().equals(loginRequest.getPassWorld())){
//                return  userMapper.userToUserDto(user);
//            }
//        }
//        return null;
//    }
    public UserDto checkLogin(String username,String passworld){
        User user= userRepository.findByUserName(username);
        if(user!=null){
            if(user.getPassWorld().equals(passworld)){
                return  userMapper.userToUserDto(user);
            }
        }
        return null;
    }

}
