package com.springframework.breweryshop.web.controller;


import com.springframework.breweryshop.web.model.CustomerDto;
import com.springframework.breweryshop.web.services.CustomerService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Customer controller class.
 *
 * @version 1
 */
@Validated
@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull @PathVariable("customerId")UUID customerId) {
        return new ResponseEntity<CustomerDto>(this.customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @NotNull@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = this.customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location" , "api/v1/customer" + savedCustomer.getUuid().toString());
        return new ResponseEntity<CustomerDto>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@NotNull @PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto){
        this.customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@NotNull @PathVariable("customerId") UUID customerId) {
        this.customerService.deleteById(customerId);
    }
}
