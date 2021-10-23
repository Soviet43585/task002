package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    private List<CarResponse> getAll() {
        return carService.getAll();
    }

    @GetMapping("/auth/mysales")
    public List<CarResponse> getMyCars(@AuthenticationPrincipal UserPrincipal user) {
        return carService.getAllByUserId(user.getId());
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
