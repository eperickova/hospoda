package com.example.hospoda.infrastructure;

import com.example.hospoda.application.handler.product.ProductSaveHandler;
import com.example.hospoda.domain.dto.DrinkMenuDto;
import com.example.hospoda.domain.entities.Product;
import com.example.hospoda.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drink-menu")
public class DrinkMenuControler {

    private final ProductRepository productRepository;

    @PostMapping
    public void save(@RequestBody DrinkMenuDto drinkMenuDto){
        ProductSaveHandler productSaveHandler= new ProductSaveHandler();
        productSaveHandler.handler(drinkMenuDto,productRepository);
    }

    @GetMapping
    public List<Product> getList(){
        return productRepository.findAll();
    }


}
