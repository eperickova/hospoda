package com.example.hospoda.infrastructure;

import com.example.hospoda.application.assembler.summary.SummaryAllAssembler;
import com.example.hospoda.application.handler.summary.SummaryProductHandler;
import com.example.hospoda.application.handler.summary.SummaryUserHandler;
import com.example.hospoda.domain.dto.SummaryCustomerDto;
import com.example.hospoda.domain.dto.SummaryProductDto;
import com.example.hospoda.domain.dto.SummaryUserProductDto;
import com.example.hospoda.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/summary")
public class SummaryControler {

    private final CustomerRepository customerRepository;

    private final SummaryAllAssembler summaryAllAssembler;

    @GetMapping("/all")
    public Map<Integer, SummaryProductDto> getAllProducts() {
        return summaryAllAssembler.assemble();
    }

    @GetMapping("/product")
    public List<SummaryCustomerDto> getUsersOrders(){
        SummaryProductHandler summaryProductHandler= new SummaryProductHandler();
        return summaryProductHandler.handle(customerRepository);
    }

    @GetMapping("/user")
    public Map<Integer, SummaryUserProductDto> getUsersProducts(){
        SummaryUserHandler summaryUserHandler= new SummaryUserHandler();
        return summaryUserHandler.handle(customerRepository);

    }

}
