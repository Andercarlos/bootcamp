package com.santander.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StockDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Digits(integer = 6, fraction = 2)
    private Double price;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private LocalDate date;
    @NotNull
    @Digits(integer = 6, fraction = 3)
    private Double variation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }
}