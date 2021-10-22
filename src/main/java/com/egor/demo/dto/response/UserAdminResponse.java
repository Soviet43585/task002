package com.egor.demo.dto.response;

import com.egor.demo.model.Role;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserAdminResponse {

    private Long id;

    private String login;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
