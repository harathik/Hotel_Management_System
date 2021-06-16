package com.hotel.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.Security.dto.CredentialsDto;
import com.hotel.Security.dto.UserDto;
import com.hotel.Security.services.UserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody CredentialsDto credentialsDto) {
        return ResponseEntity.ok(userService.signIn(credentialsDto));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<UserDto> signIn(@RequestParam String token) {
        return ResponseEntity.ok(userService.validateToken(token));
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody CredentialsDto credentialsDto){
        return ResponseEntity.ok(userService.createUser(credentialsDto));
    }
    @PutMapping("/updateUser/{email}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String email ,@RequestBody CredentialsDto credentialsDto){
        return ResponseEntity.ok(userService.updateUser(email,credentialsDto));
    }
}
