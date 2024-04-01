package com.social.app.controller;

import com.social.app.entity.User;
import com.social.app.repository.UserRepository;
import com.social.app.request.UserLoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User register(@RequestBody UserLoginRequest userLoginRequest) {

        User build = User.builder()
            .phone(userLoginRequest.getPhone())
            .password(passwordEncoder.encode(userLoginRequest.getPassword()))
            .build();

        return userRepository.save(build);
    }
}

