package com.egor.demo.service;

import com.egor.demo.dto.request.ChangeUserRoleRequest;
import com.egor.demo.dto.request.CreateUserRequest;
import com.egor.demo.dto.response.UserAdminResponse;
import com.egor.demo.model.User;

import java.util.List;

public interface UserService {

    void updateRoleById(ChangeUserRoleRequest changeUserRoleRequest);

    List<UserAdminResponse> findAllUsers();

    void registerUser(CreateUserRequest createUserRequest);

}
