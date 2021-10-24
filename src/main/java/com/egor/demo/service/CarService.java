package com.egor.demo.service;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    Page<CarResponse> getAllByUserId(Long id, Pageable pageable);

    Page<CarResponse> getAll(Pageable pageable);

    void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest);

    void update(UserPrincipal userPrincipal, Long id, CreateCarRequest createCarRequest);

    void delete(UserPrincipal userPrincipal, Long id);

}
