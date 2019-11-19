package com.haud.telecom.service;

import com.haud.telecom.dtos.CustomerDto;


public interface CustomerService {

	Integer createCustomer(CustomerDto customerDto);

	CustomerDto retrieveCustomer(Integer custId);

}
