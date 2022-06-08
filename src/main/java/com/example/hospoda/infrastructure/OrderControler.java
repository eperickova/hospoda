package com.example.hospoda.infrastructure;

import com.example.hospoda.application.handler.order.OrderSaveHandler;
import com.example.hospoda.domain.dto.OrderDto;
import com.example.hospoda.domain.entities.Product;
import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.application.factory.OrderFactory;
import com.example.hospoda.domain.repository.ProductRepository;
import com.example.hospoda.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderControler {

    private final OrderRepository orderRepository;
    private final OrderFactory orderFactory;
    private final ProductRepository productRepository;

    @PostMapping
    public String save(@RequestBody OrderDto orderDto) {

        OrderSaveHandler orderSaveHandler= new OrderSaveHandler();
        return orderSaveHandler.handle(orderDto,orderRepository,orderFactory,productRepository);
    }

}
