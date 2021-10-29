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

import com.example.demo.model.Cursos;
import com.example.demo.repository.ICursosRepository;

@RestController
@RequestMapping(path = "/api")
public class CursosController {
	
	@Autowired
	private ICursosRepository repo;
	
	@GetMapping(path ="/cursos")
	public List<Cursos> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path ="/cursos/{id}")
	public Cursos getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(path ="/cursos")
	public Cursos post(@RequestBody Cursos cursos) {
		return this.repo.save(cursos);
	}
	
	@DeleteMapping(path ="/cursos/{id}")
	public void delete(@PathVariable int id) {
		if(this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
		}
	}
	
	@PutMapping(path ="/cursos")
	public Cursos put(@RequestBody Cursos novo) {		
		return this.repo.findById(novo.getId())
				.map(cat -> {
					cat.setDescricao(novo.getDescricao());
					return this.repo.save(cat);
				})
				.orElse(null);		
	}	
		
	@GetMapping(path= "/cursos/paginacao")
	public Page<Cursos> getAll(
			@RequestParam(value = "page", defaultValue ="0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size			
			){
		PageRequest pr = PageRequest.of(page, size);
		Page<Cursos> lista = this.repo.findAll(pr);
		return lista;				
	}
	
	@GetMapping(path = "/cursos/{inicio}/id/{fim}")
	public List<Cursos> getByCursosID(@PathVariable Integer inicio, @PathVariable Integer fim){
		return this.repo.findByIdBetween(inicio, fim);
	}
	
	@GetMapping(path = "/cursos/busca/{name}")
	public List<Cursos> getCursosNome(@PathVariable String name){
		return this.repo.findByDescricao(name);
	}
}
