package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    @GetMapping("/car/{id}")
    public DetailCarResponse more(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/car/all")
    public Page<CarResponse> getAll(Pageable pageable) {
        return carService.getAll(pageable);
    }

    @GetMapping("/car/sort/byType")
    public Page<CarResponse> getAllAndSortByType(Pageable pageable) {
        return carService.getAllAndSortByType(pageable);
    }

    @GetMapping("/car/sort/byPrice")
    public Page<CarResponse> getAllAndSortByPrice(Pageable pageable) {
        return carService.getAllAndSortByPrice(pageable);
    }

    @GetMapping("/car/filter/{type}")
    public Page<CarResponse> filterByType(@PathVariable String type, Pageable pageable) {
        return carService.getAllByType(type, pageable);
    }



    @GetMapping("/user/mySales")
    public Page<CarResponse> getMyCars(@AuthenticationPrincipal UserPrincipal user, Pageable pageable) {
        return carService.getAllByUserId(user.getId(), pageable);
    }

    @PostMapping("/user")
    public void add(@AuthenticationPrincipal UserPrincipal user, @RequestBody CreateCarRequest createCarRequest) {
        carService.create(user, createCarRequest);
    }

    @PutMapping("/user/{id}")
    public void update(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long id, @RequestBody CreateCarRequest createCarRequest) {
        carService.update(user, id, createCarRequest);
    }

    @PatchMapping("/user/{id}")
    public void delete(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long id) {
        carService.delete(user, id);
    }

}
