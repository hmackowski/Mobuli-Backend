package com.mobuli.controller;

import com.mobuli.dto.LoginDto;
import com.mobuli.dto.RegisterDto;
import com.mobuli.entity.User;
import com.mobuli.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    //Build Register Rest api
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        System.out.println("User registered successfully!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String response = authService.login(loginDto);
        System.out.println("User logged successfully!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getUserID")
    public Optional<User> getUserID(@RequestBody User user){
        System.out.println(user.getEmailAddress() + " was searched for!");
        return authService.getUserID(user);
    }
}
