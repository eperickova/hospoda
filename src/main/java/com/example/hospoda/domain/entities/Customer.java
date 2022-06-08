package com.example.hospoda.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(schema = "hospoda", name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Boolean isActive;
    LocalDate birth;
    Integer pocket;
    @OneToMany(mappedBy = "customer")
    List<Order> orderList;
}
