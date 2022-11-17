package com.fatec.fatecinterativa.sala;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALA")
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SALA")
	private Integer idSala;
	
	private String sala;
	
	private String descricao;
	
	private Integer idPredio;

	
	public Sala() {
		super();
	}


	public Sala(Integer idSala, String sala, String descricao, Integer idPredio) {
		super();
		this.idSala = idSala;
		this.sala = sala;
		this.descricao = descricao;
		this.idPredio = idPredio;
	}


	public Integer getIdSala() {
		return idSala;
	}


	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getIdPredio() {
		return idPredio;
	}


	public void setIdPredio(Integer idPredio) {
		this.idPredio = idPredio;
	}

	
	
}
