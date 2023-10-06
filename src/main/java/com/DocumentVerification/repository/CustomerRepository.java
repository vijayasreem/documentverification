
package com.DocumentVerification.repository;

import com.DocumentVerification.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.verified = true")
    List<Customer> findVerifiedCustomers();

    @Query("SELECT c FROM Customer c WHERE c.verified = false")
    List<Customer> findUnverifiedCustomers();

    List<Customer> findByLoanEligible(boolean loanEligible);
}
