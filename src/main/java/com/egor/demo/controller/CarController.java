package com.egor.demo.controller;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/car")
public class CarController {

    private final CarService carService;

    @PostMapping
    public void add(@AuthenticationPrincipal UserPrincipal user, @RequestBody CreateCarRequest createCarRequest) {
        carService.create(user, createCarRequest);
    }

}
