package com.desafio.recrutamento.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCidade;
	
	private String nome;
	private String estado;
	
	public Cidade() {}
	
	public Cidade(String nome, String estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}
	
	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
