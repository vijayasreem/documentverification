
package com.DocumentVerification.repository;

import com.DocumentVerification.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Method to find a customer by their ID
    Customer findById(long id);

    // Method to find a customer by their name
    Customer findByName(String name);

    // Method to find customers with a credit score above a given threshold
    @Query("SELECT c FROM Customer c WHERE c.creditScore > ?1")
    List<Customer> findCustomersByCreditScoreGreaterThan(int threshold);

    // Method to find customers with a credit score below a given threshold
    @Query("SELECT c FROM Customer c WHERE c.creditScore < ?1")
    List<Customer> findCustomersByCreditScoreLessThan(int threshold);
}
