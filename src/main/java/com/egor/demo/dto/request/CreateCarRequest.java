package com.egor.demo.dto.request;

import lombok.Data;

@Data
public class CreateCarRequest {

    private Long id;

    private String model;

    private String type;

    private Double price;

    private String description;

}
