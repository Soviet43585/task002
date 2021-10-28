package com.egor.demo.service.impl;


import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.mapper.CarDtoToEntityMapper;
import com.egor.demo.mapper.DetailCarMapper;
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
    private final DetailCarMapper detailCarMapper;

    @Override
    public DetailCarResponse getCarById(Long id) {
        Car car = carRepository.getById(id);
        return detailCarMapper.carEntityToDetailDto(car);
    }

    @Override
    public Page<CarResponse> getAllAndSortByType(Pageable pageable) {
        List<CarResponse> list = new ArrayList<>();
        list = carRepository.findByOrderByTypeAsc(pageable).stream().map(carDtoToEntityMapper::carEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    @Override
    public Page<CarResponse> getAllAndSortByPrice(Pageable pageable) {
        return new PageImpl<>(carRepository.findByOrderByPriceAsc(pageable).stream().map(carDtoToEntityMapper::carEntityToDto).collect(Collectors.toList()));
    }

    @Override
    public Page<CarResponse> getAllByUserId(Long id, Pageable pageable) {
        List<CarResponse> list = new ArrayList<>();
        list = carRepository.findAllByUserId(id, pageable).stream().map(carDtoToEntityMapper::carEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    @Override
    public Page<CarResponse> getAllByType(String type, Pageable pageable) {
        List<CarResponse> list = new ArrayList<>();
        list = carRepository.findAllByType(type, pageable).stream().map(carDtoToEntityMapper::carEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    @Override
    public Page<CarResponse> getAll(Pageable pageable) {
        List<CarResponse> list = new ArrayList<>();
        list = carRepository.findAll(pageable).stream().map(carDtoToEntityMapper::carEntityToDto).collect(Collectors.toList());
        return new PageImpl<>(list);
    }

    @Override
    public void create(UserPrincipal userPrincipal, CreateCarRequest createCarRequest) {
        Car newCar = carDtoToEntityMapper.carDtoToEntity(createCarRequest);
        newCar.setUserId(userPrincipal.getId());
        newCar.setActive(true);
        carRepository.save(newCar);
    }

    @Override
    public void update(UserPrincipal userPrincipal, Long id, CreateCarRequest createCarRequest) {
        List<Car> cars = carRepository.findAllByUserId(userPrincipal.getId());
        if(!isUserOwner(cars, id)) {
            throw new EntityNotFoundException("You can't update this sale. You is not owner.");
        }
        else {
            Car car = carRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Not Found")
            );
            car.setModel(createCarRequest.getModel());
            car.setType(createCarRequest.getType());
            car.setPrice(createCarRequest.getPrice());
            car.setDescription(createCarRequest.getDescription());
            carRepository.save(car);
        }
    }

    @Override
    public void delete(UserPrincipal userPrincipal, Long id) {
        List<Car> cars = carRepository.findAllByUserId(userPrincipal.getId());
        if(!isUserOwner(cars, id)) {
            throw new EntityNotFoundException("You can't update this sale. You is not owner.");
        }
        else {
            Car car = carRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Not Found")
            );
            car.setActive(false);
            carRepository.save(car);
        }
    }

    @Override
    public Boolean isUserOwner(List<Car> cars, Long id) {
        return cars.stream().anyMatch(s -> s.getId().equals(id));
    }


}
