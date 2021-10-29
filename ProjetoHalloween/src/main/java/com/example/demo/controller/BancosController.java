package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bancos;
import com.example.demo.repository.IBancosRepository;

@RestController
@RequestMapping(path = "/api")
public class BancosController {
	
	@Autowired
	private IBancosRepository repo;
	
	@GetMapping(path ="/bancos")
	public List<Bancos> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path ="/bancos/{id}")
	public Bancos getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(path ="/bancos")
	public Bancos post(@RequestBody Bancos bancos) {
		return this.repo.save(bancos);
	}
	
	@DeleteMapping(path ="/bancos/{id}")
	public void delete(@PathVariable int id) {
		if(this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
		}
	}
	
	@PutMapping(path ="/bancos")
	public Bancos put(@RequestBody Bancos novo) {		
		return this.repo.findById(novo.getId())
				.map(cat -> {
					cat.setCodigoBanco(novo.getCodigoBanco());
					cat.setDescricao(novo.getDescricao());
					cat.setSite(novo.getSite());
					return this.repo.save(cat);
				})
				.orElse(null);		
	}	
	
	@GetMapping(path= "/bancos/paginacao")
	public Page<Bancos> getAll(
			@RequestParam(value = "page", defaultValue ="0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size			
			){
		PageRequest pr = PageRequest.of(page, size);
		Page<Bancos> lista = this.repo.findAll(pr);
		return lista;				
	}
	
	@GetMapping(path = "/bancos/{inicio}/id/{fim}")
	public List<Bancos> getBybancosID(@PathVariable Integer inicio, @PathVariable Integer fim){
		return this.repo.findByIdBetween(inicio, fim);
	}
	
	@GetMapping(path = "/bancos/busca/{name}")
	public List<Bancos> getBancoNome(@PathVariable String name){
		return this.repo.findByDescricao(name);
	}
}
