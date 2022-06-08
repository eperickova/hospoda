package com.example.hospoda.application.handler.user;

import com.example.hospoda.domain.dto.UserCreateDto;
import com.example.hospoda.domain.entities.Customer;
import com.example.hospoda.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserSaveHandler {
    public void userSaveHandler() {}
    public void handle(UserCreateDto userCreateDto, CustomerRepository customerRepository){
        var user= new Customer();
        user.setBirth(userCreateDto.getBirth());
        user.setIsActive(true);
        user.setName(userCreateDto.getName());
        user.setPocket(100);
        customerRepository.save(user);
    }
}
