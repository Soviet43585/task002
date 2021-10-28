package com.egor.demo.dto.request;

import javax.validation.constraints.Size;

public class CreateUserRequest {

    @Size(min = 4, message = "Login should have more then 3 symbols")
    private String login;

    @Size(min = 4, message = "Password should have more then 3 symbols")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
