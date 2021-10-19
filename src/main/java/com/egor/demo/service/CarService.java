package com.egor.demo.service;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.security.UserPrincipal;

public interface CarService {

    void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest);


}
