package com.example.hospoda.application.handler.summary;

import com.example.hospoda.domain.dto.SummaryCustomerDto;
import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryProductHandler {
    public void summaryProductHandler(){}
    public List<SummaryCustomerDto> handle(CustomerRepository customerRepository){

        return customerRepository.findAll().stream().map(customer -> {
            SummaryCustomerDto summaryCustomerDto= new SummaryCustomerDto();
            summaryCustomerDto.setUserId(customer.getId());
            summaryCustomerDto.setAmount(0);
            summaryCustomerDto.setPrice(0);
            for (Order order: customer.getOrderList()){
                for(OrderItem item: order.getOrderItemList()){
                    summaryCustomerDto.setAmount(summaryCustomerDto.getAmount()+ item.getAmount());
                    summaryCustomerDto.setPrice(summaryCustomerDto.getPrice()+ (item.getPrice()* item.getAmount()));
                }
            }
            return summaryCustomerDto;
        }).toList();
    }
}
