package com.DocumentVerification.service;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentVerificationService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer verifyIdentity(Long customerId) {
        Customer customer = customerRepository.findByIdentityVerifiedIsTrueAndId(customerId);
        // Perform identity verification logic here
        return customer;
    }

    public Customer verifyAddress(Long customerId) {
        Customer customer = customerRepository.findByAddressVerifiedIsTrueAndId(customerId);
        // Perform address verification logic here (e.g., send OTP to customer's mobile number)
        return customer;
    }

    public void notifyVerificationResult(boolean isIdentityVerified, boolean isAddressVerified) {
        String eligibilityMessage;
        if (isIdentityVerified && isAddressVerified) {
            eligibilityMessage = "Congratulations! You are now eligible for banking services.";
        } else if (isIdentityVerified) {
            eligibilityMessage = "Your identity is verified, but address verification is pending.";
        } else if (isAddressVerified) {
            eligibilityMessage = "Your address is verified, but identity verification is pending.";
        } else {
            eligibilityMessage = "Both identity and address verification are pending.";
        }
        System.out.println(eligibilityMessage);
    }

    // Other methods for document verification and customer management can be added here
    
    // Unit testing can be conducted to verify the accuracy of the eligibility message when both identity and address document verification results are considered

    // API documentation and usage guidelines can be added as comments here or in a separate documentation file
}