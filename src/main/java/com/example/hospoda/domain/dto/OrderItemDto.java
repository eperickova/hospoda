package com.example.hospoda.domain.dto;


import lombok.Data;

@Data
public class OrderItemDto {
    Integer id;
    String productName;
    Integer amount;
    Integer price;
}
