package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserRequest;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;

    public UserDto checkLogin(String username,String passworld){
        User user= userRepository.findByUserName(username);
        if(user!=null){
            if(user.getPassWorld().equals(passworld)){
                return  userMapper.userToUserDto(user);
            }
        }
        return null;
    }
    public List<UserDto> getAll(){
        List<User> user= userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user1 : user
        ){
            userDtos.add(userMapper.userToUserDto(user1));
        }
        return userDtos;
    }
    public Role getRole(int role_id){
        Role role= new Role();
        List<Role> roles = roleRepository.findAll();
        for (Role role1 : roles
        ){
            if(role1.getId()==role_id){
                role= role1;
                return role;
            }
        }
        return role;
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
        Role role= getRole(createUserRequest.getRole());
        user.setRole(role);
        if(user.getRole()!=null){
            userRepository.save(user);
        }
        user.setPoint(0);
        return userMapper.userToUserDto(user);
    }

    public boolean updateUser(CreateUserRequest createUserRequest,int id){
        try {
            userRepository.updateUser(createUserRequest.getFullName(), createUserRequest.getPassWorld(), createUserRequest.getPhone(), createUserRequest.getEmail(), id);
            return true;
        }catch (Exception e){
            return false;
        }
        }
    }

