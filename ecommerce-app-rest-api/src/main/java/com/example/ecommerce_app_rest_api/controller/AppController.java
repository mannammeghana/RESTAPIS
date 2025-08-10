package com.example.ecommerce_app_rest_api.controller;

import com.example.ecommerce_app_rest_api.model.*;
import com.example.ecommerce_app_rest_api.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {
    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;
    private final PaymentService paymentService;

    public AppController(CustomerService customerService, ProductService productService,
                         OrderService orderService, PaymentService paymentService) {
        this.customerService = customerService;
        this.productService = productService;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    // Customer
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAll();
    }

    // Product
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAll();
    }

    // Order
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order.setOrderDate(LocalDateTime.now());
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderService.getAll();
    }

    // Payment
    @PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        payment.setPaymentDate(LocalDateTime.now());
        payment.setStatus("Completed");
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.CREATED);
    }

    @GetMapping("/payments")
    public List<Payment> getPayments() {
        return paymentService.getAll();
    }
}
