package com.example.hospoda.application.handler.user;

import com.example.hospoda.domain.dto.CustomerOrderDto;
import com.example.hospoda.domain.dto.OrderItemDto;
import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersOrdersHandler {

    public void usersOrdersHandler(){}
    public CustomerOrderDto handler(Integer userId, CustomerRepository customerRepository){
        return customerRepository.findById(userId).map(user->{
            CustomerOrderDto customerOrderDto= new CustomerOrderDto();
            customerOrderDto.setId(user.getId());
            customerOrderDto.setName(user.getName());
            customerOrderDto.setIsActive(user.getIsActive());
            customerOrderDto.setPocket(user.getPocket());
            LocalDate date=user.getBirth().plusYears(18);
            if(date.isAfter(LocalDate.now())){
                customerOrderDto.setIsAdult(false);
            }else{
                customerOrderDto.setIsAdult(true);
            }

            Map<Integer, List<OrderItemDto>> orderMap = new HashMap<>();

            for(Order order : user.getOrderList()){

                List<OrderItemDto> list = new ArrayList<>();

                for(OrderItem item: order.getOrderItemList())
                {
                    OrderItemDto orderItemDto = new OrderItemDto();
                    orderItemDto.setId(item.getId());
                    orderItemDto.setAmount(item.getAmount());
                    orderItemDto.setPrice(item.getPrice());
                    orderItemDto.setProductName(item.getProduct().getName());
                    list.add(orderItemDto);
                }
                orderMap.put(order.getId(),list);
            }
            customerOrderDto.setOrderMap(orderMap);
            return customerOrderDto;
        }).get();
    }
}
