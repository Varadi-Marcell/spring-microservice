package com.example.orderservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastname;
    private LocalDateTime orderTime;
    private double price;
    private Long userId;

    public Order(String firstName, String lastname, double price,Long userId) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.orderTime = LocalDateTime.now();
        this.price = price;
        this.userId = userId;
    }
}
