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

import com.example.demo.model.AreaConhecimento;
import com.example.demo.repository.IAreaConhecimentoRepository;

@RestController
@RequestMapping(path = "/api")
public class AreaConhecimentoController {
	
	@Autowired
	private IAreaConhecimentoRepository repo;
	
	@GetMapping(path ="/areaconhecimento")
	public List<AreaConhecimento> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping(path ="/areaconhecimento/{id}")
	public AreaConhecimento getById(@PathVariable int id) {
		return this.repo.findById(id).orElse(null);
	}
	
	@PostMapping(path ="/areaconhecimento")
	public AreaConhecimento post(@RequestBody AreaConhecimento area) {
		return this.repo.save(area);
	}
	
	@DeleteMapping(path ="/areaconhecimento/{id}")
	public void delete(@PathVariable int id) {
		if(this.repo.findById(id).orElse(null) != null) {
			this.repo.deleteById(id);
		}
	}
	
	@PutMapping(path ="/areaconhecimento")
	public AreaConhecimento put(@RequestBody AreaConhecimento novo) {		
		return this.repo.findById(novo.getId())
				.map(cat -> {
					cat.setDescricao(novo.getDescricao());
					return this.repo.save(cat);
				})
				.orElse(null);		
	}	
	
	@GetMapping(path= "/areaconhecimento/paginacao")
	public Page<AreaConhecimento> getAll(
			@RequestParam(value = "page", defaultValue ="0") Integer page,
			@RequestParam(value = "size", defaultValue = "4") Integer size			
			){
		PageRequest pr = PageRequest.of(page, size);
		Page<AreaConhecimento> lista = this.repo.findAll(pr);
		return lista;				
	}
	
	@GetMapping(path = "/areaconhecimento/{inicio}/id/{fim}")
	public List<AreaConhecimento> getByAreaID(@PathVariable Integer inicio, @PathVariable Integer fim){
		return this.repo.findByIdBetween(inicio, fim);
	}
	
	@GetMapping(path = "/areaconhecimento/busca/{name}")
	public List<AreaConhecimento> getAreaConhecimentoNome(@PathVariable String name){
		return this.repo.findByDescricao(name);
	}
}
