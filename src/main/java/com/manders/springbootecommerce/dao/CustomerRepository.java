package com.manders.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manders.springbootecommerce.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
