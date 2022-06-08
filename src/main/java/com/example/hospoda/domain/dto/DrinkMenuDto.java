package com.example.hospoda.domain.dto;

import lombok.Data;

@Data
public class DrinkMenuDto {
    private String name;
    private Integer price;
    private Boolean isForAdult;
}
