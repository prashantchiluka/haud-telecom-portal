package com.haud.telecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haud.telecom.dtos.SimcardDto;
import com.haud.telecom.service.SimcardService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/simcard")
@Slf4j
public class SimcardController {

	@Autowired
	SimcardService simcardService;

	@PostMapping("/create/{custId}")
	public ResponseEntity<Integer> createSimcard(@RequestBody SimcardDto simcardDto, @PathVariable Integer custId) {

		log.info("Saving sim card " + simcardDto);
		return new ResponseEntity<>(simcardService.createSimcard(simcardDto, custId), HttpStatus.CREATED);	

	}

	@GetMapping("/retreiveCustomerSims/{simcardId}")
	public ResponseEntity<SimcardDto> retreiveCustomerSims(@PathVariable Integer simcardId) {

		log.info("Retreive Customer Sims" + simcardId);
		return new ResponseEntity<>(simcardService.retreiveCustomerSims(simcardId), HttpStatus.OK);

	}

}
