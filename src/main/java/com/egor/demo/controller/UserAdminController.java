package com.egor.demo.controller;

import com.egor.demo.dto.request.ChangeUserRoleRequest;
import com.egor.demo.dto.response.UserAdminResponse;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class UserAdminController {

    private final UserService userService;

    @PatchMapping("/setRole")
    public void updateRole(@RequestBody ChangeUserRoleRequest changeUserRoleRequest) {

        userService.updateRoleById(changeUserRoleRequest);

    }

    @GetMapping("/all")
    public List<UserAdminResponse> all() {
        return userService.findAllUsers();
    }
}
