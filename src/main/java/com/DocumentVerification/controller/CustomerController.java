package com.DocumentVerification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/verifyDocument")
	public ResponseEntity<List<Customer>> verifyDocument(@RequestBody Customer customer) {
		List<Customer> customers = customerService.verifyCustomersByDocumentVerification(customer.isDocumentVerification());
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@PostMapping("/notifyVerification")
	public ResponseEntity<List<Customer>> notifyVerification(@RequestBody Customer customer) {
		List<Customer> customers = customerService.notifyCustomersByVerificationTimeliness(customer.isVerificationTimeliness());
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@PostMapping("/assessEligibility")
	public ResponseEntity<List<Customer>> assessEligibility(@RequestBody Customer customer) {
		List<Customer> customers = customerService.assessCustomersByEligibility(customer.isEligibility());
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

}