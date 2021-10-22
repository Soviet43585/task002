package com.egor.demo.dto.request;

import com.egor.demo.model.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ChangeUserRoleRequest {

    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
