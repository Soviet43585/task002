package com.egor.demo.dto.request;

public class PriceFilterRequest {

    private Double min;

    private Double max;

    public Double getMin() {
        return this.min;
    }

    public Double getMax() {
        return this.max;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public void setMax(Double max) {
        this.max = max;
    }
}
