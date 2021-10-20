package com.egor.demo.service.impl;

import com.egor.demo.dto.request.ChangeUserRoleRequest;
import com.egor.demo.dto.response.UserAdminResponse;
import com.egor.demo.mapper.UserDtoToEntityMapper;
import com.egor.demo.model.User;
import com.egor.demo.repository.UserRepository;
import com.egor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDtoToEntityMapper userDtoToEntityMapper;


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

}
