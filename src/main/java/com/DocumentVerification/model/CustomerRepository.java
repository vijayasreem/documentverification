
package com.DocumentVerification.repository;

import com.DocumentVerification.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM com.DocumentVerification.model.Customer c WHERE c.isIdentityVerified = true")
    boolean existsCustomerWithIdentityVerification();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM com.DocumentVerification.model.Customer c WHERE c.isAddressVerified = true")
    boolean existsCustomerWithAddressVerification();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM com.DocumentVerification.model.Customer c WHERE c.isIdentityVerified = true AND c.isAddressVerified = true")
    boolean existsCustomerWithCompleteVerification();

    // Other required methods and queries can be added here
}
