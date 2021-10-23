package com.egor.demo.service.impl;


import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.mapper.CarDtoToEntityMapper;
import com.egor.demo.model.Car;
import com.egor.demo.repository.CarRepository;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarDtoToEntityMapper carDtoToEntityMapper;

    @Override
    public List<CarResponse> getAllByUserId(Long id) {
        List<Car> list = carRepository.findAllByUserId(id);
        List<CarResponse> newCar = new ArrayList<>();
        for(Car car : list) {
            newCar.add(carDtoToEntityMapper.carEntityToDto(car));
        }
        return newCar;
    }

    @Override
    public List<CarResponse> getAll() {
        List<Car> list = carRepository.findAll();
        List<CarResponse> newCar = new ArrayList<>();
        for(Car car : list) {
            newCar.add(carDtoToEntityMapper.carEntityToDto(car));
        }
        return newCar;
    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest) {
        Car newCar = carDtoToEntityMapper.carDtoToEntity(createCarRequest);
        newCar.setUserId(userPrincipal.getId());
        carRepository.save(newCar);
    }

    @Override
    public void update(UserPrincipal userPrincipal, Long id, CreateCarRequest createCarRequest) {
        List<Car> cars = carRepository.findAllByUserId(userPrincipal.getId());
        if(cars == null) {
            throw new EntityNotFoundException("User have not cars");
        }
        else {
            for(Car car : cars) {
                if (car.getId() == id) {
                    car.setModel(createCarRequest.getModel());
                    car.setType(createCarRequest.getType());
                    car.setPrice(createCarRequest.getPrice());
                    car.setDescription(createCarRequest.getDescription());
                    carRepository.save(car);
                }
            }
        }
    }
}
