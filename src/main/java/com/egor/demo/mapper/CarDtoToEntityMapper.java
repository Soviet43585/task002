package com.egor.demo.mapper;

import com.egor.demo.dto.request.CreateCarRequest;
import com.egor.demo.dto.response.CarResponse;
import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarDtoToEntityMapper {

    Car carDtoToEntity(CreateCarRequest createCarRequest);

    CarResponse carEntityToDto(Car car);

}
