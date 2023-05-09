package com.springframework.breweryshop.web.controller;


import com.springframework.breweryshop.web.model.CustomerDto;
import com.springframework.breweryshop.web.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * Customer controller class.
 *
 * @version 1
 */
@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId) {
        return new ResponseEntity<CustomerDto>(this.customerService.getCustomerById(customerId), HttpStatus.OK);
    }
}
