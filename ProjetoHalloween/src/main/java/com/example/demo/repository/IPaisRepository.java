package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Pais;

public interface IPaisRepository extends JpaRepository<Pais, Integer> {
	
	List<Pais> findByIdBetween(Integer inicio, Integer fim);
	
	List<Pais> findByDescricao(String descricao);

}
