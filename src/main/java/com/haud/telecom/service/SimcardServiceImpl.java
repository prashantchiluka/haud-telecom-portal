package com.haud.telecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haud.telecom.dtos.SimcardDto;
import com.haud.telecom.exceptions.EntityNotFound;
import com.haud.telecom.model.Customer;
import com.haud.telecom.model.Simcard;
import com.haud.telecom.repository.CustomerRepository;
import com.haud.telecom.repository.SimcardRepository;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class SimcardServiceImpl implements SimcardService {

	@Autowired
	SimcardRepository simcardRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Integer createSimcard(SimcardDto simcardDto, Integer custId) {
		log.info("in service impl, creating simcard " + simcardDto);

		Customer customer = customerRepository.findById(custId)
				.orElseThrow(() -> new EntityNotFound("Customer Not Found"));

		Simcard simcard = modelMapper.map(simcardDto, Simcard.class);

		simcard.setCustomer(customer);
		log.info("in service impl, creating simcard, repository call ");
		return simcardRepository.save(simcard).getId();

	}

	@Override
	public SimcardDto retreiveCustomerSims(Integer simcardId) {
		log.info("in service impl, retrieving specific customer sims: " + simcardId + "repository call");
		return modelMapper.map(
				simcardRepository.findById(simcardId).orElseThrow(() -> new EntityNotFound("Simcard Not Found")),
				SimcardDto.class);
	}

}
