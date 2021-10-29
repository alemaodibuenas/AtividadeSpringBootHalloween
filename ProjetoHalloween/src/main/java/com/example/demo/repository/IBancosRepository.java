package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Bancos;

public interface IBancosRepository extends JpaRepository<Bancos, Integer> {
	
	List<Bancos> findByIdBetween(Integer inicio, Integer fim);
	
	List<Bancos> findByDescricao(String descricao);
}
