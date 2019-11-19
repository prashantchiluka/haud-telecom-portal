package com.haud.telecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haud.telecom.dtos.CustomerDto;
import com.haud.telecom.exceptions.EntityNotFound;
import com.haud.telecom.model.Customer;
import com.haud.telecom.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Integer createCustomer(CustomerDto customerDto) {
		log.info("in service impl, adding customer " + customerDto);
		return customerRepository.save(modelMapper.map(customerDto, Customer.class)).getId();
	}

	@Override
	public CustomerDto retrieveCustomer(Integer custId) {
		log.info("in service impl, getting specific customer with id: " + custId + "repository call");
		return modelMapper.map(
				customerRepository.findById(custId).orElseThrow(() -> new EntityNotFound("Customer Not Found")),
				CustomerDto.class);

	}

}
