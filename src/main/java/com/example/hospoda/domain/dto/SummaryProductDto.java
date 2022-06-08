package com.example.hospoda.domain.dto;

import lombok.Data;

@Data
public class SummaryProductDto {

    Integer id;
    String productName;
    Integer amount;
    Integer unitPrice;
    Integer SummaryPrice;
}
