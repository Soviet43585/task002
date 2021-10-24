package com.egor.demo.mapper;

import com.egor.demo.dto.response.DetailCarResponse;
import com.egor.demo.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailCarMapper {
    DetailCarResponse carEntityToDetailDto(Car car);
}
