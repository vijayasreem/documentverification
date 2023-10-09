package com.DocumentVerification.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	//method to verify customer documents accurately and quickly
	public List<Customer> verifyCustomersByDocumentVerification(boolean documentVerification) {
		List<Customer> customers = new ArrayList<>();
		Optional<List<Customer>> customerList = customerRepository.findByDocumentVerification(documentVerification);
		if (customerList.isPresent()) {
			customers = customerList.get();
		}
		return customers;
	}

	//method to notify customer of verification results in a timely manner
	public List<Customer> notifyCustomersByVerificationTimeliness(boolean verificationTimeliness) {
		List<Customer> customers = new ArrayList<>();
		Optional<List<Customer>> customerList = customerRepository.findByVerificationTimeliness(verificationTimeliness);
		if (customerList.isPresent()) {
			customers = customerList.get();
		}
		return customers;
	}

	//method to assess customer eligibility for a loan
	public List<Customer> assessCustomersByEligibility(boolean eligibility) {
		List<Customer> customers = new ArrayList<>();
		Optional<List<Customer>> customerList = customerRepository.findByEligibility(eligibility);
		if (customerList.isPresent()) {
			customers = customerList.get();
		}
		return customers;
	}

}