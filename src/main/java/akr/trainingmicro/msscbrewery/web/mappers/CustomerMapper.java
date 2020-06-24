package akr.trainingmicro.msscbrewery.web.mappers;

import org.mapstruct.Mapper;

import akr.trainingmicro.msscbrewery.domain.Customer;
import akr.trainingmicro.msscbrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

	CustomerDto customerToCustomerDto(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDto customerDto);
	
}
