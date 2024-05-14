package com.mobuli.service;

import com.mobuli.dto.LoginDto;
import com.mobuli.dto.RegisterDto;
import com.mobuli.entity.Role;
import com.mobuli.entity.User;
import com.mobuli.exception.MobuliAPIException;
import com.mobuli.repository.RoleRepository;
import com.mobuli.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class DefaultAuthService implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDto registerDto) {

        // check if username is already existing in the database
        if (userRepository.existsByUserName(registerDto.getUserName())) {
            throw new MobuliAPIException(HttpStatus.BAD_REQUEST, "Username already exists.");
        }

        //check if email is already existing in database.
        if (userRepository.existsByEmailAddress(registerDto.getEmail())) {
            throw new MobuliAPIException(HttpStatus.BAD_REQUEST, "Email already exists.");
        }

        User user = new User();
        user.setFirstName(registerDto.getFirstName());
        user.setLastName(registerDto.getLastName());
        user.setUserName(registerDto.getUserName());
        user.setEmailAddress(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);

        user.setAccountCreatedAt(currentTime);
        user.setPasswordUpdatedAt(currentTime);

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

        return "User Registered Successfully!";
    }

    @Override
    public String login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getEmailAddress(),
                    loginDto.getPassword()
            ));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "User logged in successfully.";
        } catch (AuthenticationException e) {
            return "Wrong email address or password was used.";
        }

    }

    @Override
    public Optional<User> getUserID(User user) {
        return userRepository.findByEmailAddress(user.getEmailAddress());
    }
}
