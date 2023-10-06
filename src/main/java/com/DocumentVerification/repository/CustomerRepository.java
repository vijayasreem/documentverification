
package com.DocumentVerification.repository;

import com.DocumentVerification.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    // Custom queries for document verification
    
    Customer findByEmail(String email);
    
    // Add more custom queries as needed
    
}
