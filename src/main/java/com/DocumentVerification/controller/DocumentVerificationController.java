package com.DocumentVerification.controller;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.repository.CustomerRepository;
import com.DocumentVerification.service.DocumentVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentVerificationController {

    @Autowired
    private DocumentVerificationService documentVerificationService;

    @PostMapping("/verifyIdentity/{customerId}")
    public Customer verifyIdentity(@PathVariable Long customerId) {
        return documentVerificationService.verifyIdentity(customerId);
    }

    @PostMapping("/verifyAddress/{customerId}")
    public Customer verifyAddress(@PathVariable Long customerId) {
        return documentVerificationService.verifyAddress(customerId);
    }

    @PostMapping("/notifyVerificationResult/{isIdentityVerified}/{isAddressVerified}")
    public void notifyVerificationResult(@PathVariable boolean isIdentityVerified, @PathVariable boolean isAddressVerified) {
        documentVerificationService.notifyVerificationResult(isIdentityVerified, isAddressVerified);
    }

    // Other endpoints for document verification and customer management can be added here

    // API documentation and usage guidelines can be added as comments here or in a separate documentation file
}