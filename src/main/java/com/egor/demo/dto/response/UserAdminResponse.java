package com.egor.demo.dto.response;

import com.egor.demo.model.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserAdminResponse {

    private Long id;

    private String login;

    @Enumerated(EnumType.STRING)
    private Role role;

}
