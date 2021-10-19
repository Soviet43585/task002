package com.egor.demo.service;

import com.egor.demo.dto.request.ChangeUserRoleRequest;

public interface UserService {

    void updateRoleById(ChangeUserRoleRequest changeUserRoleRequest);

}
