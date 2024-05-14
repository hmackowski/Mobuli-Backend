package com.mobuli.service;

import com.mobuli.dto.LoginDto;
import com.mobuli.dto.RegisterDto;
import com.mobuli.entity.User;

import java.util.Optional;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
    Optional<User> getUserID(User user);
}
