package com.egor.demo.security;


import java.util.ArrayList;
import java.util.List;

import com.egor.demo.model.Role;
import com.egor.demo.model.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
public final class UserFactory {

    public static UserDetails create(User user) {
        return new UserPrincipal(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRole(),
                mapToGrantedAuthorities(user.getRole())
        ) {
        };
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role userRole) {
        List<GrantedAuthority> userRoles = new ArrayList<>();
        userRoles.add(new SimpleGrantedAuthority(userRole.name()));
        return userRoles;
    }
}
