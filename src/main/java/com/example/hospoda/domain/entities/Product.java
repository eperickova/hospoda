package com.example.hospoda.domain.entities;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(schema = "hospoda", name = "drink_menu")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer price;
    Boolean isForAdult;

    @OneToMany(mappedBy = "product")
    List<OrderItem> orderItemList;
}
