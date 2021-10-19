package com.egor.demo.service.impl;


import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.mapper.CarDtoToEntityMapper;
import com.egor.demo.model.Car;
import com.egor.demo.repository.CarRepository;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarDtoToEntityMapper carDtoToEntityMapper;
    private final ModelMapper modelMapper;

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest) {
        Car newCar = carDtoToEntityMapper.carDtoToEntity(createCarRequest);
        newCar.setLogin(userPrincipal.getUsername());
        carRepository.save(newCar);
    }
}
