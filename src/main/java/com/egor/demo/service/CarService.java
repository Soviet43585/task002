package com.egor.demo.service;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.security.UserPrincipal;

import java.util.List;

public interface CarService {

    List<CarResponse> getAllByUserId(Long id);

    List<CarResponse> getAll();

    void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest);

    void update(UserPrincipal userPrincipal, Long id, CreateCarRequest createCarRequest);

}
