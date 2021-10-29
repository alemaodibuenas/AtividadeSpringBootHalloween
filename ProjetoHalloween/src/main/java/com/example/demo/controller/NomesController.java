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

import com.example.demo.model.Nomes;
import com.example.demo.repository.INomesRepository;

@RestController
@RequestMapping(path = "/api")
public class NomesController {
	
	@Autowired
	private INomesRepository repo;
	
	@GetMapping(path ="/nomes")
	public List<Nomes> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path ="/nomes/{id}")
	public Nomes getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(path ="/nomes")
	public Nomes post(@RequestBody Nomes nomes) {
		return this.repo.save(nomes);
	}
	
	@DeleteMapping(path ="/nomes/{id}")
	public void delete(@PathVariable int id) {
		if(this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
		}
	}
	
	@PutMapping(path ="/nomes")
	public Nomes put(@RequestBody Nomes novo) {		
		return this.repo.findById(novo.getId())
				.map(cat -> {
					cat.setNome(novo.getNome());
					cat.setSexo(novo.getSexo());
					return this.repo.save(cat);
				})
				.orElse(null);		
	}	
	
	@GetMapping(path= "/nomes/paginacao")
	public Page<Nomes> getAll(
			@RequestParam(value = "page", defaultValue ="0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size			
			){
		PageRequest pr = PageRequest.of(page, size);
		Page<Nomes> lista = this.repo.findAll(pr);
		return lista;				
	}
	
	@GetMapping(path = "/nomes/{inicio}/id/{fim}")
	public List<Nomes> getNomeID(@PathVariable Integer inicio, @PathVariable Integer fim){
		return this.repo.findByIdBetween(inicio, fim);
	}
	
	@GetMapping(path = "/nomes/busca/{name}")
	public List<Nomes> getNome(@PathVariable String name){
		return this.repo.findByNome(name);
	}

}
