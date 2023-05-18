package com.example.orderservice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public void createOrder(Order order){
        orderRepository.save(order);
    }
    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }

}
