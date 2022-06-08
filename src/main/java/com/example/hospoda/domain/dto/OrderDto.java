package com.example.hospoda.domain.dto;

import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;

@Data
public class OrderDto {

    Integer customerId;
    Integer productId;
    Integer amount;
}
