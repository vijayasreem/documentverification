
package com.DocumentVerification.repository;

import com.DocumentVerification.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Identity verification query
    Customer findByIdentityVerifiedIsTrueAndId(Long id);

    // Address verification query
    Customer findByAddressVerifiedIsTrueAndId(Long id);
}
