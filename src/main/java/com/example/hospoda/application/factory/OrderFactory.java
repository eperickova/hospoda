package com.example.hospoda.application.factory;

import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderFactory {
    private final CustomerRepository customerRepository;
    public Order build(Integer customerId){
        var order = new Order();
        order.setCustomer(customerRepository.findById(customerId).get());
        order.setOrderItemList(new ArrayList<>());
        return order;
    }
}
