package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AreaConhecimento;

public interface IAreaConhecimentoRepository extends JpaRepository<AreaConhecimento, Integer> {
	
	List<AreaConhecimento> findByIdBetween(Integer inicio, Integer fim);
	
	List<AreaConhecimento> findByDescricao(String descricao);
}
