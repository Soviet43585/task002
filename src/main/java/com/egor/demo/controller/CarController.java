package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    private Page<CarResponse> getAll(Pageable pageable) {
        return carService.getAll(pageable);
    }

    @GetMapping("/auth/mysales")
    public Page<CarResponse> getMyCars(@AuthenticationPrincipal UserPrincipal user, Pageable pageable) {
        return carService.getAllByUserId(user.getId(), pageable);
    }

    @PostMapping("/auth")
    public void add(@AuthenticationPrincipal UserPrincipal user, @RequestBody CreateCarRequest createCarRequest) {
        carService.create(user, createCarRequest);
    }

    @PutMapping("/auth/{id}")
    public void update(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long id, @RequestBody CreateCarRequest createCarRequest) {
        carService.update(user, id, createCarRequest);
    }

    @PatchMapping("/auth/{id}")
    public void delete(@AuthenticationPrincipal UserPrincipal user, @PathVariable Long id) {
        carService.delete(user, id);
    }

}
