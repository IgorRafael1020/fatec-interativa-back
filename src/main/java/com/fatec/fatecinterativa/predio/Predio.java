package com.fatec.fatecinterativa.predio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PREDIO")
public class Predio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PREDIO")
	private Integer idPredio;
	
	private String predio;
	
	private String descricao;

	public Predio() {
		super();
	}

	public Predio(Integer idPredio, String predio, String descricao) {
		super();
		this.idPredio = idPredio;
		this.predio = predio;
		this.descricao = descricao;
	}

	public Integer getIdPredio() {
		return idPredio;
	}

	public void setIdPredio(Integer idPredio) {
		this.idPredio = idPredio;
	}

	public String getPredio() {
		return predio;
	}

	public void setPredio(String predio) {
		this.predio = predio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
