package com.springframework.breweryshop.web.services;

import com.springframework.breweryshop.web.model.BeerDto;
import com.springframework.breweryshop.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);
}
