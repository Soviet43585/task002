package com.egor.demo.dto.response;

import com.egor.demo.model.User;

public class DetailCarResponse extends CarResponse{

    private String description;

    private User user;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser() {
        return user.getLogin();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
