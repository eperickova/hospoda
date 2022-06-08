package com.example.hospoda.application.handler.product;

import com.example.hospoda.domain.dto.DrinkMenuDto;
import com.example.hospoda.domain.entities.Product;
import com.example.hospoda.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductSaveHandler {
    public void productSaveHandler(){}

    public void handler(DrinkMenuDto drinkMenuDto, ProductRepository productRepository){
        var drink= new Product();
        drink.setName(drinkMenuDto.getName());
        drink.setPrice(drinkMenuDto.getPrice());
        drink.setIsForAdult(drinkMenuDto.getIsForAdult());

        productRepository.save(drink);
    }
}
