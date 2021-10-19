package com.egor.demo.service.impl;

import com.egor.demo.dto.request.ChangeUserRoleRequest;
import com.egor.demo.model.User;
import com.egor.demo.repository.UserRepository;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void updateRoleById(ChangeUserRoleRequest changeUserRoleRequest) {
        User user = userRepository.findById(changeUserRoleRequest.getId()).orElseThrow(() -> new EntityNotFoundException("User with id" + changeUserRoleRequest.getId() + "not found"));
        user.setRole(changeUserRoleRequest.getRole());
        userRepository.save(user);
    }

}
