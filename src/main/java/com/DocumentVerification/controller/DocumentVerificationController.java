package com.DocumentVerification.controller;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.service.DocumentVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-verification")
public class DocumentVerificationController {

    @Autowired
    private DocumentVerificationService documentVerificationService;

    @PostMapping("/verify-identity/{customerId}")
    public boolean verifyIdentity(@PathVariable Long customerId) {
        return documentVerificationService.verifyIdentity(customerId);
    }

    @PostMapping("/verify-address/{customerId}")
    public boolean verifyAddress(@PathVariable Long customerId) {
        return documentVerificationService.verifyAddress(customerId);
    }

    @GetMapping("/notify-verification-result/{customerId}")
    public String notifyVerificationResult(@PathVariable Long customerId) {
        return documentVerificationService.notifyVerificationResult(customerId);
    }
    
    // Other required endpoints and business logic can be added here
}