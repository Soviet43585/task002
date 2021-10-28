package com.egor.demo.mapper;

import com.egor.demo.dto.request.CreateUserRequest;
import com.egor.demo.dto.response.UserAdminResponse;
import com.egor.demo.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoToEntityMapper {

    UserAdminResponse userEntityToDto(User user);

    User userDtoToEntity(CreateUserRequest createUserRequest);

}
