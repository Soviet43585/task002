package com.egor.demo.service.impl;


import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.mapper.CarDtoToEntityMapper;
import com.egor.demo.model.Car;
import com.egor.demo.repository.CarRepository;
import com.egor.demo.security.UserPrincipal;
import com.egor.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarDtoToEntityMapper carDtoToEntityMapper;

    @Override
    public Page<CarResponse> getAllByUserId(Long id, Pageable pageable) {
        List<CarResponse> list = new ArrayList<>();
        list = carRepository.findAllByUserId(id, pageable).stream().map(carDtoToEntityMapper::carEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(list);
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

    @Override
    public void delete(UserPrincipal userPrincipal, Long id) {
        List<Car> cars = carRepository.findAllByUserId(userPrincipal.getId());
        if(cars == null) {
            throw new EntityNotFoundException("User have not cars");
        }
        else {
            for(Car car : cars) {
                if (car.getId() == id) {
                    car.setActive(false);
                    carRepository.save(car);
                }
            }
        }
    }
}
