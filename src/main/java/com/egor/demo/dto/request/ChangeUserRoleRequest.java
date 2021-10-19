package com.egor.demo.dto.request;

import com.egor.demo.model.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ChangeUserRoleRequest {

    @Enumerated(EnumType.STRING)
    private Role role;
}
