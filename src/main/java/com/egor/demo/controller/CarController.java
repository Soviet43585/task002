package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.request.PriceFilterRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/car/filter/byPrice")
    public Page<CarResponse> filterByType(@RequestBody PriceFilterRequest priceFilterRequest, Pageable pageable) {
        return carService.getAllByPrice(priceFilterRequest, pageable);
    }

    @GetMapping("/car/service/getMyCars")
    public Page<CarResponse> getMyCars(@AuthenticationPrincipal UserPrincipal user, Pageable pageable) {
        return carService.getAllByUserId(user.getId(), pageable);
    }

    @PostMapping("/car/service/add")
    public String add(@AuthenticationPrincipal UserPrincipal user, @Valid @RequestBody CreateCarRequest createCarRequest, BindingResult bindingResult) {
        return carService.create(user, createCarRequest, bindingResult);
    }

    @PutMapping("/car/service/update/{id}")
    public String update(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long id,@Valid @RequestBody CreateCarRequest createCarRequest, BindingResult bindingResult) {
        return carService.update(user, id, createCarRequest, bindingResult);
    }

    @PatchMapping("/car/service/delete/{id}")
    public void delete(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long id) {
        carService.delete(user, id);
    }

}
