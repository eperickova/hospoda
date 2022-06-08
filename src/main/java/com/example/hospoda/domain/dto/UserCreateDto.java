package com.example.hospoda.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreateDto {
    private String name;
    private LocalDate birth;

}
