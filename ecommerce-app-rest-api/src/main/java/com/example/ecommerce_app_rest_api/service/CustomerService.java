package com.example.ecommerce_app_rest_api.service;

import com.example.ecommerce_app_rest_api.model.Customer;
import com.example.ecommerce_app_rest_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer save(Customer customer) { 
    	return customerRepository.save(customer); 
    	}
    
    public List<Customer> getAll() { 
    	return customerRepository.findAll(); 
    	}
}
