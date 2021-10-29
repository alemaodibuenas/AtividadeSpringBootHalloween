package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Bancos")
public class Bancos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "COD_BANCO")
	private Integer codigoBanco;
	
	@Column(name = "DESCR")
	private String descricao;
	
	@Column(name = "SITE")
	private String site;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Bancos(Integer id, Integer codigoBanco, String descricao, String site) {
		super();
		this.id = id;
		this.codigoBanco = codigoBanco;
		this.descricao = descricao;
		this.site = site;
	}

	@Override
	public String toString() {
		return "Bancos [id=" + id + ", codigoBanco=" + codigoBanco + ", descricao=" + descricao + ", site=" + site
				+ "]";
	}
	
	public Bancos() {}

}
