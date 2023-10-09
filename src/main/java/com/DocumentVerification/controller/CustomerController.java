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

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @GetMapping("/name/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.findByName(name);
    }

    @GetMapping("/credit-score-greater-than/{threshold}")
    public List<Customer> getCustomersByCreditScoreGreaterThan(@PathVariable int threshold) {
        return customerService.findCustomersByCreditScoreGreaterThan(threshold);
    }

    @GetMapping("/credit-score-less-than/{threshold}")
    public List<Customer> getCustomersByCreditScoreLessThan(@PathVariable int threshold) {
        return customerService.findCustomersByCreditScoreLessThan(threshold);
    }
}