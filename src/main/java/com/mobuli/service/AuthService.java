package com.mobuli.service;

import com.mobuli.dto.LoginDto;
import com.mobuli.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
