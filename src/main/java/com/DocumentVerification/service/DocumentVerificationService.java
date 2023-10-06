package com.DocumentVerification.service;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentVerificationService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean verifyIdentity(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            customer.setIdentityVerified(true);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public boolean verifyAddress(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            customer.setAddressVerified(true);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public String notifyVerificationResult(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            boolean isIdentityVerified = customer.isIdentityVerified();
            boolean isAddressVerified = customer.isAddressVerified();

            if (isIdentityVerified && isAddressVerified) {
                return "Document verification is complete. Customer is eligible for banking services.";
            } else if (!isIdentityVerified && isAddressVerified) {
                return "Identity document verification is pending. Customer is not eligible for banking services.";
            } else if (isIdentityVerified && !isAddressVerified) {
                return "Address document verification is pending. Customer is not eligible for banking services.";
            } else {
                return "Both identity and address document verifications are pending. Customer is not eligible for banking services.";
            }
        }
        return "Customer not found.";
    }
    
    // Other required methods and business logic can be added here
}