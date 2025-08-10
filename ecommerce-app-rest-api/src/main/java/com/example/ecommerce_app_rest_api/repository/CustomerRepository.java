package com.example.ecommerce_app_rest_api.repository;

import com.example.ecommerce_app_rest_api.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}

