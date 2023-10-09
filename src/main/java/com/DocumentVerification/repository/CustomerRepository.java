package com.DocumentVerification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DocumentVerification.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	//method to verify customer documents accurately and quickly
	public Customer findByDocumentVerification(boolean documentVerification);

	//method to notify customer of verification results in a timely manner
	public Customer findByVerificationTimeliness(boolean verificationTimeliness);

	//method to assess customer eligibility for a loan
	public Customer findByEligibility(boolean eligibility);

}