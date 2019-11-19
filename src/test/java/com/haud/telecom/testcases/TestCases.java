package com.haud.telecom.testcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.haud.telecom.controller.CustomerController;
import com.haud.telecom.controller.SimcardController;
import com.haud.telecom.dtos.CustomerDto;
import com.haud.telecom.dtos.SimcardDto;
import com.haud.telecom.service.CustomerService;
import com.haud.telecom.service.SimcardService;

@ExtendWith(MockitoExtension.class)

public class TestCases {
	@InjectMocks
	CustomerController customerController;

	
	@InjectMocks
	SimcardController simcardController;
		
	@Mock
	CustomerService customerService;
	
	@Mock
	SimcardService simcardService;
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void TestCreateCustomer() {

		CustomerDto customerDto = new CustomerDto();
		
		customerService.createCustomer(customerDto);
		verify(customerService, times(1)).createCustomer(customerDto);
	}

	
	@Test
	public void TestRetrieveCustomer() {
		CustomerDto customerDto = new CustomerDto("Mathew","Mathe@Gmail.com");
		
		when(customerService.retrieveCustomer(3)).thenReturn(customerDto);

		CustomerDto customer = customerService.retrieveCustomer(3);

		assertEquals("Mathew", customer.getName());
		assertEquals("Mathe@Gmail.com", customer.getEmail());
		
	}
	
	
	// 	Customer test cases ends ............................................................
	//   Simcard Test cases Starts .......................................................... 
		
	
	
	@Test
	public void createSimcardTest() {

		SimcardDto simcardDto = new SimcardDto(1,123, 65);	

		simcardService.createSimcard(simcardDto, 4);
		verify(simcardService, times(1)).createSimcard(simcardDto, 4);
	}

	@Test
	public void testRetreiveCustomerSims() {
		
		SimcardDto simcardDto = new SimcardDto(1,123, 65);	
		
		when(simcardService.retreiveCustomerSims(4)).thenReturn(simcardDto);

		SimcardDto sim = simcardService.retreiveCustomerSims(4);
		
		assertEquals(Integer.valueOf(65), sim.getIMSINumber());
		assertEquals(Integer.valueOf(123), sim.getSIMNumber());
		
	}

}
