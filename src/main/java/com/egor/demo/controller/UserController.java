package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateUserRequest;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody CreateUserRequest createUserRequest, BindingResult bindingResult) {
        return userService.registerUser(createUserRequest, bindingResult);
    }

}
