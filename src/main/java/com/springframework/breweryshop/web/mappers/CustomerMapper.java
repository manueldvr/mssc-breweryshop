package com.springframework.breweryshop.web.mappers;

import com.springframework.breweryshop.web.domain.Customer;
import com.springframework.breweryshop.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
