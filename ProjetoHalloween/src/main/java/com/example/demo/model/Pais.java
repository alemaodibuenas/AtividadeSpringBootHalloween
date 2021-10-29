package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")	
	private Integer id;
	
	@Column(name = "SIGLA_PAIS")	
	private String siglaPais;
	
	@Column(name = "COD_IDIOMA")	
	private String codigoIdioma;
	
	@Column(name = "DESCR")	
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSiglaPais() {
		return siglaPais;
	}

	public void setSiglaPais(String siglaPais) {
		this.siglaPais = siglaPais;
	}

	public String getCodigoIdioma() {
		return codigoIdioma;
	}

	public void setCodigoIdioma(String codigoIdioma) {
		this.codigoIdioma = codigoIdioma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pais(Integer id, String siglaPais, String codigoIdioma, String descricao) {
		super();
		this.id = id;
		this.siglaPais = siglaPais;
		this.codigoIdioma = codigoIdioma;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", siglaPais=" + siglaPais + ", codigoIdioma=" + codigoIdioma + ", descricao="
				+ descricao + "]";
	}
	
	public Pais() {}	

}
