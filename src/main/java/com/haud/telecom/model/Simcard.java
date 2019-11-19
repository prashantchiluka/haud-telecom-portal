package com.haud.telecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "simcard")
@Builder
@Setter
@Getter
public class Simcard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "simcard_id")
	private Integer id;

	@JsonIgnore
	@ManyToOne
	private Customer customer;

	private Integer sIMNumber;
	private Integer iMSINumber;

}
