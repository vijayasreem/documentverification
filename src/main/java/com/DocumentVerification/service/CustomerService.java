package com.DocumentVerification.service;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(long id) {
        return customerRepository.findById(id);
    }

    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    public List<Customer> findCustomersByCreditScoreGreaterThan(int threshold) {
        return customerRepository.findCustomersByCreditScoreGreaterThan(threshold);
    }

    public List<Customer> findCustomersByCreditScoreLessThan(int threshold) {
        return customerRepository.findCustomersByCreditScoreLessThan(threshold);
    }
}