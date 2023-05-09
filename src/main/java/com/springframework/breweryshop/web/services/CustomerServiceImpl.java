package com.springframework.breweryshop.web.services;

import com.springframework.breweryshop.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    /**
     * Get Customer by Id.
     * @param
     * @return CustomerDto
     */
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().uuid(UUID.randomUUID()).name("John Smith").build();
    }
}
