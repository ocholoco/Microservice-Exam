package com.microservice.exam.service;

import com.microservice.exam.dto.CustomerDTO;
import com.microservice.exam.entity.Customer;
import com.microservice.exam.repository.CustomerRepository;
import com.microservice.exam.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<?> createCustomer(CustomerDTO requestDTO) {
        if (requestDTO.getCustomerEmail() == null || requestDTO.getCustomerEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email is a required field");
        }

        Customer customer = new Customer();
        customer.setCustomerName(requestDTO.getCustomerName());
        customer.setCustomerMobile(requestDTO.getCustomerMobile());
        customer.setCustomerEmail(requestDTO.getCustomerEmail());
        customer.setAddress1(requestDTO.getAddress1());
        customer.setAddress2(requestDTO.getAddress2());
        customer.setAccountType(requestDTO.getAccountType());
        customer.setCustomerNumber(generateRandomCustomerNumber());

        Customer savedCustomer = customerRepository.save(customer);

        CustomerResponse responseDTO = new CustomerResponse();
        responseDTO.setCustomerNumber(savedCustomer.getCustomerNumber());
        responseDTO.setTransactionStatusCode(201);
        responseDTO.setTransactionStatusDescription("Customer account created");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    public ResponseEntity<?> getCustomerDetails(Long customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerNumber(customerNumber);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();

            CustomerResponse responseDTO = new CustomerResponse();
            responseDTO.setCustomerNumber(customer.getCustomerNumber());
            responseDTO.setTransactionStatusCode(302);
            responseDTO.setTransactionStatusDescription("Customer Account found");

            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found");
        }
    }

    private long generateRandomCustomerNumber() {
        Random random = new Random();
        return random.nextInt(99999999) + 1;
    }
}
