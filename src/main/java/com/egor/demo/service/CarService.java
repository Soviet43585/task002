package com.egor.demo.service;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.model.Car;
import com.egor.demo.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    DetailCarResponse getCarById(Long id);

    Page<CarResponse> getAllByUserId(Long id, Pageable pageable);

    Page<CarResponse> getAll(Pageable pageable);

    void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest);

    void update(UserPrincipal userPrincipal, Long id, CreateCarRequest createCarRequest);

    void delete(UserPrincipal userPrincipal, Long id);

    Boolean isUserOwner(List<Car> cars, Long id); //method check user request for update and delete him sales (is user owner this sale)

}
