package com.manders.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manders.springbootecommerce.entity.Customer;

// CustomerRepository is NOT annotated
// Hence it will Not be exposed as REST API based on our configurations
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Customer findByEmail(String email);
}
