package com.egor.demo.service.impl;

import com.egor.demo.dto.request.ChangeUserRoleRequest;
import com.egor.demo.dto.request.CreateUserRequest;
import com.egor.demo.dto.response.UserAdminResponse;
import com.egor.demo.mapper.UserDtoToEntityMapper;
import com.egor.demo.model.Role;
import com.egor.demo.model.User;
import com.egor.demo.repository.UserRepository;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoToEntityMapper userDtoToEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void updateRoleById(ChangeUserRoleRequest changeUserRoleRequest) {
        User user = userRepository.findById(changeUserRoleRequest.getId()).orElseThrow(() -> new EntityNotFoundException("User with id" + changeUserRoleRequest.getId() + "not found"));
        user.setRole(changeUserRoleRequest.getRole());
        userRepository.save(user);
    }

    @Override
    public List<UserAdminResponse> findAllUsers() {

        List<User> list = userRepository.findAll();
        List<UserAdminResponse> all = new ArrayList<>();
        for(User user : list) {
            all.add(userDtoToEntityMapper.userEntityToDto(user));
        }
        return all;
    }

    @Override
    public void registerUser(CreateUserRequest createUserRequest) {
        User newUser = userDtoToEntityMapper.userDtoToEntity(createUserRequest);
        newUser.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        newUser.setRole(Role.ROLE_USER);
        userRepository.save(newUser);
    }

}
