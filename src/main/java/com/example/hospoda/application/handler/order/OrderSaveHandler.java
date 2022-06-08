package com.example.hospoda.application.handler.order;

import com.example.hospoda.application.factory.OrderFactory;
import com.example.hospoda.domain.dto.OrderDto;
import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.domain.entities.Product;
import com.example.hospoda.domain.repository.OrderRepository;
import com.example.hospoda.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderSaveHandler {

    public void orderSaveHandler(){}
    public String handle(OrderDto orderDto, OrderRepository orderRepository, OrderFactory OrderFactory, ProductRepository productRepository){

        Order order = orderRepository.findBycustomer_id(orderDto.getCustomerId())
                .orElse(OrderFactory.build(orderDto.getCustomerId()));

        Product product = productRepository.findById(orderDto.getProductId()).get();
        if(order.getCustomer().getBirth().plusYears(18).isAfter(LocalDate.now()) && product.getIsForAdult()){
            return "Zakaznik nie je plnolety!";
        }

        OrderItem item= new OrderItem();
        item.setAmount(orderDto.getAmount());
        item.setOrder(order);
        item.setProduct(product);
        item.setPrice(product.getPrice());
        order.getOrderItemList().add(item);

        if(order.getCustomer().getPocket()<orderDto.getAmount() * product.getPrice()){
            return "Nedostatok financii!";
        }

        orderRepository.save(order);
        order.getCustomer().setPocket(order.getCustomer().getPocket()-orderDto.getAmount() * product.getPrice());
        return "Objednavka prijata.";
    }
}
