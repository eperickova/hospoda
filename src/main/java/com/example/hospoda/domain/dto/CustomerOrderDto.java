package com.example.hospoda.domain.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CustomerOrderDto {
    Integer id;
    String name;
    Boolean isActive;
    Boolean isAdult;
    Integer pocket;
    Map<Integer,List<OrderItemDto>> orderMap;
}
