package com.haud.telecom.service;

import com.haud.telecom.dtos.SimcardDto;

public interface SimcardService {

	Integer createSimcard(SimcardDto simcardDto, Integer custId);

	SimcardDto retreiveCustomerSims(Integer simcardId);

}
