package com.example.hospoda.application.assembler.summary;

import com.example.hospoda.domain.dto.SummaryProductDto;
import com.example.hospoda.domain.entities.OrderItem;
import com.example.hospoda.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SummaryAllAssembler {

    private final ProductRepository productRepository;
    public Map<Integer, SummaryProductDto> assemble(){
        return productRepository.findAll().stream().map(product -> {
                    SummaryProductDto summaryProductDto = new SummaryProductDto();
                    summaryProductDto.setProductName(product.getName());
                    summaryProductDto.setUnitPrice(product.getPrice());
                    summaryProductDto.setSummaryPrice(0);
                    summaryProductDto.setAmount(0);
                    summaryProductDto.setId(product.getId());
                    for (OrderItem orderItem : product.getOrderItemList()) {
                        summaryProductDto.setAmount(summaryProductDto.getAmount() + orderItem.getAmount());
                        summaryProductDto.setSummaryPrice(summaryProductDto.getAmount() * summaryProductDto.getUnitPrice());
                    }
                    return summaryProductDto;
                })
                .collect(Collectors.toMap(SummaryProductDto::getId, Function.identity()));
    }
}
