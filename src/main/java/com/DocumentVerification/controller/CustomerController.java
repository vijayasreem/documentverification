package com.DocumentVerification.controller;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/verified")
    public List<Customer> getVerifiedCustomers() {
        return customerService.getVerifiedCustomers();
    }

    @GetMapping("/unverified")
    public List<Customer> getUnverifiedCustomers() {
        return customerService.getUnverifiedCustomers();
    }

    @GetMapping("/loanEligible")
    public List<Customer> getCustomersByLoanEligibility(@RequestParam boolean loanEligible) {
        return customerService.getCustomersByLoanEligibility(loanEligible);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}