package com.egor.demo.security;

import java.util.Collection;

import com.egor.demo.model.Role;
import com.egor.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

    private final User user;
    Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(
            Long id,
            String login,
            String password,
            Role role,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.user = User.builder()
                .id(id)
                .login(login)
                .password(password)
                .role(role)
                .build();
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return user.getId();
    }
}
