package com.example.ecommerce_app_rest_api.service;

import com.example.ecommerce_app_rest_api.model.Order;
import com.example.ecommerce_app_rest_api.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
