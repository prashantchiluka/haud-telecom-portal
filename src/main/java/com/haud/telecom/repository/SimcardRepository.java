package com.haud.telecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haud.telecom.model.Simcard;

@Repository
public interface SimcardRepository extends JpaRepository<Simcard, Integer> {

}
