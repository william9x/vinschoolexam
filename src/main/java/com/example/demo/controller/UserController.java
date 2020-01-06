package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserRequest;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "/*")
@RestController
@RequestMapping("/api/user")
@Api(value = "User APIs")
public class UserController {
    @Autowired
    private UserService userService;
@Autowired
private UserRepository userRepository;

    //login
    @ApiOperation(value="User login", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping("")
    public ResponseEntity<?> studentLogin(@RequestBody @Valid LoginRequest loginRequest) {
        UserDto user = userService.checkLogin(loginRequest.getUserName(),loginRequest.getPassWorld());
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value="Create User", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PostMapping ("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        UserDto user = userService.createUser(createUserRequest);
        if(user.getRole()==null){
           return ResponseEntity.ok(null);
        }
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(null);
    }
    @ApiOperation(value="Get all user", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping ("/getAll")
    public ResponseEntity<?> getAllUser() {
        List<UserDto> user = userService.getAll();
        if(user==null){
            return ResponseEntity.ok(null);
        }

        return ResponseEntity.ok(user);
    }
    @ApiOperation(value="Update user", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> updateUser(@RequestBody @Valid CreateUserRequest createUserRequest, @RequestParam int id) {
        boolean check=userService.updateUser(createUserRequest,id);
        return ResponseEntity.ok(check);
    }
    @ApiOperation(value="Get user detail", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getUserDetail(@RequestParam int id) {
        UserDto userDto =userService.getUserDetail(id);
        return ResponseEntity.ok(userDto);
    }
}
