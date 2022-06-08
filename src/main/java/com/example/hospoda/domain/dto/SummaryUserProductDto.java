package com.example.hospoda.domain.dto;

import lombok.Data;

import java.util.Map;

@Data
public class SummaryUserProductDto {
    Integer userId;
    Map<String,Integer> productMap;
}
