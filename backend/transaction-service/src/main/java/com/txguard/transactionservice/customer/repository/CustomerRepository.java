package com.txguard.transactionservice.customer.repository;

import com.txguard.transactionservice.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByUpiId(String upiId);

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByMobileNumber(String mobileNumber);

    boolean existsByUpiId(String upiId);

    boolean existsByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);
}