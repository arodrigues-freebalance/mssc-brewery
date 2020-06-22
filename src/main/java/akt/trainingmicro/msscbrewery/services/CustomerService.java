package akt.trainingmicro.msscbrewery.services;

import java.util.UUID;

import akt.trainingmicro.msscbrewery.web.model.CustomerDto;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);	
	
}
