package com.springframework.breweryshop.web.services;

import com.springframework.breweryshop.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{

    /**
     * Get Customer by Id.
     * @param customerId id
     * @return CustomerDto
     */
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().uuid(UUID.randomUUID()).name("John Smith").build();
    }

    /**
     * Create new customer object
     * @param customerDto DTO
     * @return customer
     */
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().uuid(UUID.randomUUID()).name("Tom Clancy").build();
    }

    /**
     * Update existing customer.
     * @param customerId id
     * @param customerDto DTO
     */
    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {

    }

    /**
     * Delete customer by id
     * @param customerId UUID
     */
    @Override
    public void deleteById(UUID customerId) {

    }
}
