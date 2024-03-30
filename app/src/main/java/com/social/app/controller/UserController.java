package com.social.app.controller;

import com.social.app.entity.User;
import com.social.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    public void register(User user) {

        userRepository.save(user);
    }
}
