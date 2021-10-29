package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Nomes;

public interface INomesRepository extends JpaRepository<Nomes, Integer> {
	
	List<Nomes> findByIdBetween(Integer inicio, Integer fim);	
	
	List<Nomes> findByNome(String nome);
	
}
