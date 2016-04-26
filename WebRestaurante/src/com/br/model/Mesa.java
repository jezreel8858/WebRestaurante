package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Mesa")
public class Mesa implements EntityClass{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numero;
	private String descricao;
	private int capacidade;
	private Boolean perReserva;
	
	public Mesa() {
		
	}
	
	public Mesa(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public Boolean isPerReserva() {
		return perReserva;
	}
	public void setPerReserva(Boolean perReserva) {
		this.perReserva = perReserva;
	}
	

	public Boolean getPerReserva() {
		return perReserva;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
