package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;
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

@RestController
@RequestMapping("/api/user")
@Api(value = "User APIs")
public class UserController {
    @Autowired
    private UserService userService;
@Autowired
private UserRepository userRepository;
    @ApiOperation(value="User login", response = UserDto.class)
    @ApiResponses({
            @ApiResponse(code = 400, message="Bad request"),
            @ApiResponse(code = 500, message="Internal Server Error"),
    })
    @GetMapping("/{username}/{passworld}")
    //public ResponseEntity<?> createUser(@RequestBody @Valid LoginRequest loginRequest) {
    public ResponseEntity<?> createUser(@RequestParam  String username,@RequestParam  String passworld) {
        UserDto user = userService.checkLogin(username,passworld);
        if(user!=null){
            return ResponseEntity.ok(true);
        }
//        List<User>  users= userRepository.findAll();
        return ResponseEntity.ok(false);
    }

}
