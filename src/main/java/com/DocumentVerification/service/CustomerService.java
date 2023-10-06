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

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getVerifiedCustomers() {
        return customerRepository.findVerifiedCustomers();
    }

    public List<Customer> getUnverifiedCustomers() {
        return customerRepository.findUnverifiedCustomers();
    }

    public List<Customer> getCustomersByLoanEligibility(boolean loanEligible) {
        return customerRepository.findByLoanEligible(loanEligible);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}