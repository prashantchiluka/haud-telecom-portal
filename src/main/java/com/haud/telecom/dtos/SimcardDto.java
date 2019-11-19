package com.haud.telecom.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haud.telecom.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SimcardDto {

	private Integer id;
	private Integer sIMNumber;
	private Integer iMSINumber;
	private Customer customer;
	public SimcardDto(Integer id, Integer sIMNumber, Integer iMSINumber) {
		super();
		this.id = id;
		this.sIMNumber = sIMNumber;
		this.iMSINumber = iMSINumber;
	}
	
	
	
	
	
	

}
