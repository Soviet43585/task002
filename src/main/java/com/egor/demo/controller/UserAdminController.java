package com.egor.demo.controller;

import com.egor.demo.dto.request.ChangeUserRoleRequest;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class UserAdminController {

    private final UserService userService;

    @PatchMapping("/setRole")
    public void updateRole(@RequestBody ChangeUserRoleRequest changeUserRoleRequest) {

        userService.updateRoleById(changeUserRoleRequest);

    }

}
