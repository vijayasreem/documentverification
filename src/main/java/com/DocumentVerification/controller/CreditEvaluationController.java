package com.DocumentVerification.controller;

import com.DocumentVerification.service.CreditEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditEvaluationController {

    private final CreditEvaluationService creditEvaluationService;

    @Autowired
    public CreditEvaluationController(CreditEvaluationService creditEvaluationService) {
        this.creditEvaluationService = creditEvaluationService;
    }

    @GetMapping("/validateCreditEvaluation")
    public String validateCreditEvaluation(@RequestParam double annualIncome, @RequestParam int creditScore) {
        return creditEvaluationService.validateCreditEvaluation(annualIncome, creditScore);
    }
}