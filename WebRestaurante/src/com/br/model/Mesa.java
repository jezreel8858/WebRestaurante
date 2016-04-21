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
	private int capacidade;
	private boolean perReserva;
	
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
	
	public boolean isPerReserva() {
		return perReserva;
	}
	public void setPerReserva(boolean perReserva) {
		this.perReserva = perReserva;
	}
	
	

}
