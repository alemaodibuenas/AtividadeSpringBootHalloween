package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Nomes")
public class Nomes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private Integer id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SEXO")	
	private char sexo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Nomes(Integer id, String nome, char sexo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Nomes [id=" + id + ", nome=" + nome + ", sexo=" + sexo + "]";
	}
	
	public Nomes() {}

}
