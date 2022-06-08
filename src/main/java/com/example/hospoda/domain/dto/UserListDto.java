package com.example.hospoda.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserListDto {
    Integer id;
    String name;
    Boolean isActive;
    Boolean isAdult;
    Integer pocket;
}
