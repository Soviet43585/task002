package com.egor.demo.dto.request;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class CreateCarRequest {

    private Long id;

    @NotBlank(message = "Model should not be empty")
    private String model;

    @NotBlank(message = "Type should not be empty")
    @Pattern(regexp = "^(Cargo|Bus|Light|Moto)$", message = "Type can be only: Cargo, Bus, Light, Moto")
    private String type;

    private Double price;

    @NotBlank(message = "Description should not be empty")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
