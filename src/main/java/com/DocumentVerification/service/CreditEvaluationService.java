
package com.DocumentVerification.service;

import com.DocumentVerification.model.CreditEvaluation;
import com.DocumentVerification.repository.CreditEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditEvaluationService {

    private final CreditEvaluationRepository creditEvaluationRepository;

    @Autowired
    public CreditEvaluationService(CreditEvaluationRepository creditEvaluationRepository) {
        this.creditEvaluationRepository = creditEvaluationRepository;
    }

    public String validateCreditEvaluation(double annualIncome, int creditScore) {
        CreditEvaluation creditEvaluation = creditEvaluationRepository.findByAnnualIncomeGreaterThanEqualAndCreditScoreGreaterThanEqual(annualIncome, creditScore);

        if (creditEvaluation != null) {
            if (creditEvaluation.getAnnualIncome() >= 30000 && creditEvaluation.getCreditScore() >= 700) {
                return "Congratulations! You are pre-qualified for a loan amount and interest rate range.";
            } else if (creditEvaluation.getAnnualIncome() >= 20000 && creditEvaluation.getCreditScore() >= 600) {
                return "You are eligible for a loan amount and interest rate range.";
            }
        }

        return "Sorry, you are not eligible for a loan.";
    }
}
