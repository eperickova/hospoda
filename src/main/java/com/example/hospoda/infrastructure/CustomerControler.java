package com.example.hospoda.infrastructure;

import com.example.hospoda.application.handler.user.UserHandler;
import com.example.hospoda.application.handler.user.UserSaveHandler;
import com.example.hospoda.application.handler.user.UsersOrdersHandler;
import com.example.hospoda.domain.dto.CustomerOrderDto;
import com.example.hospoda.domain.dto.OrderItemDto;
import com.example.hospoda.domain.dto.UserCreateDto;
import com.example.hospoda.domain.dto.UserListDto;
import com.example.hospoda.domain.entities.Customer;
import com.example.hospoda.domain.entities.Order;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class CustomerControler {
    private final CustomerRepository customerRepository;

    @PostMapping
    public void save(@RequestBody UserCreateDto userCreateDto){
        UserSaveHandler userSaveHandler= new UserSaveHandler();
        userSaveHandler.handle(userCreateDto,customerRepository);
    }
    @GetMapping("/{userId}")
    public CustomerOrderDto getUser(@PathVariable Integer userId){
        UsersOrdersHandler usersOrdersHandler= new UsersOrdersHandler();
        return usersOrdersHandler.handler(userId,customerRepository);
    }

    @GetMapping
    public List<UserListDto> getList(){
        return new UserHandler().handler(customerRepository);
    }
}
