package com.microservice.exam.repository;

import com.microservice.exam.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByCustomerNumber(Long customerNumber);

    Optional<Customer> findByCustomerNumber(Long customerNumber);

}
