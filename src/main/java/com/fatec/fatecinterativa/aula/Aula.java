package com.fatec.fatecinterativa.aula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AULA")
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AULA")
	private Integer idAula;
	
	private String aula;
	
	private String dia;
	
	private String horario;
	
	private String professor;
	
	private Integer idSala;
	
	
	public Aula() {
		super();
	}


	public Aula(Integer idAula, String aula, String dia, String horario, String professor, Integer idSala) {
		super();
		this.idAula = idAula;
		this.aula = aula;
		this.dia = dia;
		this.horario = horario;
		this.professor = professor;
		this.idSala = idSala;
	}


	public Integer getIdAula() {
		return idAula;
	}


	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
	}


	public String getAula() {
		return aula;
	}


	public void setAula(String aula) {
		this.aula = aula;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getProfessor() {
		return professor;
	}


	public void setProfessor(String professor) {
		this.professor = professor;
	}


	public Integer getIdSala() {
		return idSala;
	}


	public void setIdSala(Integer idSala) {
		this.idSala = idSala;
	}
	
	
}
