package com.example.ecommerce_app_rest_api.service;

import com.example.ecommerce_app_rest_api.model.Payment;
import com.example.ecommerce_app_rest_api.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}
