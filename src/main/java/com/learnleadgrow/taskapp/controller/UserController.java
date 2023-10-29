package com.learnleadgrow.taskapp.controller;

import com.learnleadgrow.taskapp.dto.UserRequestDTO;
import com.learnleadgrow.taskapp.dto.UserResponseDTO;
import com.learnleadgrow.taskapp.model.User;
import com.learnleadgrow.taskapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Created this mapping for testing the init application
    @GetMapping("/hello")
    public ResponseEntity hello(String text) {
        return new ResponseEntity("<h1>Hello World! </h1>", HttpStatusCode.valueOf(200));
    }

    //Post method to register user to DB or app
    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        //calling UserService to store User details in DB
        UserResponseDTO userResponseDTO = userService.registerUser(user);
        return userResponseDTO;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable(name = "userId") long userId){
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


}
