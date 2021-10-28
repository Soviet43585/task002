package com.egor.demo.service;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.request.PriceFilterRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.model.Car;
import com.egor.demo.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface CarService {

    DetailCarResponse getCarById(Long id);

    Page<CarResponse> getAllByPrice(PriceFilterRequest priceFilterRequest, Pageable pageable);

    Page<CarResponse> getAllAndSortByType(Pageable pageable);

    Page<CarResponse> getAllAndSortByPrice(Pageable pageable);

    Page<CarResponse> getAllByUserId(Long id, Pageable pageable);

    Page<CarResponse> getAll(Pageable pageable);

    String create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest, BindingResult bindingResult);

    String update(UserPrincipal userPrincipal, Long id, CreateCarRequest createCarRequest, BindingResult bindingResult);

    void delete(UserPrincipal userPrincipal, Long id);

    Boolean isUserOwner(List<Car> cars, Long id); //method check user request for update and delete him sales (is user owner this sale)

    Page<CarResponse> getAllByType(String type, Pageable pageable);
}
