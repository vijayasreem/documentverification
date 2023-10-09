//Spring Boot Entity/Model class
package com.DocumentVerification.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean documentVerification;
	private boolean verificationTimeliness;
	private boolean eligibility;
	
	public Customer() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isDocumentVerification() {
		return documentVerification;
	}
	
	public void setDocumentVerification(boolean documentVerification) {
		this.documentVerification = documentVerification;
	}
	
	public boolean isVerificationTimeliness() {
		return verificationTimeliness;
	}
	
	public void setVerificationTimeliness(boolean verificationTimeliness) {
		this.verificationTimeliness = verificationTimeliness;
	}
	
	public boolean isEligibility() {
		return eligibility;
	}
	
	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}
	
}