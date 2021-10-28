package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateUserRequest;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody CreateUserRequest createUserRequest) {
        userService.registerUser(createUserRequest);
    }

}
