package com.DocumentVerification.controller;

import com.DocumentVerification.model.Customer;
import com.DocumentVerification.service.DocumentVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-verification")
public class DocumentVerificationController {

    @Autowired
    private DocumentVerificationService documentVerificationService;

    @PostMapping("/verify-identity-document")
    public ResponseEntity<String> verifyIdentityDocument(@RequestBody Customer customer) {
        boolean isVerified = documentVerificationService.verifyIdentityDocument(customer);
        if (isVerified) {
            return new ResponseEntity<>("Identity document verified successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to verify identity document.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/send-otp-for-address-verification")
    public ResponseEntity<String> sendOTPForAddressVerification(@RequestBody Customer customer) {
        boolean isOTPSent = documentVerificationService.sendOTPForAddressVerification(customer);
        if (isOTPSent) {
            return new ResponseEntity<>("OTP sent successfully for address verification.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to send OTP for address verification.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/notify-verification-result")
    public void notifyVerificationResult(@RequestBody Customer customer) {
        documentVerificationService.notifyVerificationResult(customer);
    }
    
    // Add more API endpoints as needed

}
