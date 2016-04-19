package com.br.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="Funcionario")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Funcionario extends Usuario implements Comparable<Usuario>{
	
	@Column(nullable=false)
	private float salario;
	@Column(nullable=false,length=11)
	private String cpf;
	

		
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public int compareTo(Usuario o) {
		return getNome().compareTo(o.getNome());
	}
	
}
