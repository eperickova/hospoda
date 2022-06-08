package com.example.hospoda.application.handler.summary;

import com.example.hospoda.domain.dto.SummaryUserProductDto;
import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SummaryUserHandler {
    public void summaryUserHandler(){}
    public Map<Integer, SummaryUserProductDto> handle(CustomerRepository customerRepository){
        return customerRepository.findAll().stream().map(customer -> {
            SummaryUserProductDto summaryUserProductDto= new SummaryUserProductDto();
            summaryUserProductDto.setUserId(customer.getId());
            Map<String,Integer> productMap= new HashMap<>();
            for (Order order: customer.getOrderList()){
                for (OrderItem item: order.getOrderItemList()){
                    if(productMap.containsKey(item.getProduct().getName())){
                        Integer oldPrice= productMap.get(item.getProduct().getName());
                        productMap.replace(item.getProduct().getName(),oldPrice+ (item.getPrice()* item.getAmount()));
                    }else{
                        productMap.put(item.getProduct().getName(), item.getPrice()* item.getAmount());
                    }
                }

            }
            summaryUserProductDto.setProductMap(productMap);
            return summaryUserProductDto;
        }).collect(Collectors.toMap(SummaryUserProductDto ::getUserId, Function.identity()));
    }
}
