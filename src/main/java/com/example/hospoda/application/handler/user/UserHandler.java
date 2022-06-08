package com.example.hospoda.application.handler.user;

import com.example.hospoda.domain.dto.UserListDto;
import com.example.hospoda.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserHandler {
    public void userHandler(){}

    public List<UserListDto> handler(CustomerRepository customerRepository){
        return customerRepository.findAll().stream().map(user->{
            UserListDto userListDto = new UserListDto();
            userListDto.setName(user.getName());
            userListDto.setId(user.getId());
            userListDto.setIsActive(user.getIsActive());
            userListDto.setPocket(user.getPocket());
            LocalDate date=user.getBirth().plusYears(18);
            if(date.isAfter(LocalDate.now())){
                userListDto.setIsAdult(false);
            }else{
                userListDto.setIsAdult(true);
            }

            return userListDto;
        }).toList();
    }
}
