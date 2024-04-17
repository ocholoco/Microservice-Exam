package com.microservice.exam.controller;

import com.microservice.exam.dto.CustomerDTO;
import com.microservice.exam.entity.Customer;
import com.microservice.exam.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO requestDTO) {
        ResponseEntity<?> responseEntity = customerService.createCustomer(requestDTO);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomerDetails(@PathVariable Long customerNumber) {
        ResponseEntity<?> responseEntity = customerService.getCustomerDetails(customerNumber);
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }
}