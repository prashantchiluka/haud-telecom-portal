package com.haud.telecom.dtos;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.haud.telecom.model.Simcard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class CustomerDto {

	private int id;

	private String name;

	private String email;
	@JsonIgnore
	private Collection<Simcard> simcard = new ArrayList<Simcard>();
	
	public CustomerDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
	

}
