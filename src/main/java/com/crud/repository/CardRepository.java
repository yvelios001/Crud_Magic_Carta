package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.cartas.entidade.Carta;

public interface CardRepository extends JpaRepository<Carta, Long>{
	
	

}
