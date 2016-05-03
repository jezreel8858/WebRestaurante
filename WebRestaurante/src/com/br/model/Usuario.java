package com.br.model;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements EntityClass, Comparable<Usuario>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Embedded
	private Login login;
	private String nome;
	private String email;
	private String telefone;
	@Column(nullable=true)
	private boolean desativado;
	
	public int compareTo(Usuario user) {
		return this.getNome().compareTo(user.getNome());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void createLogin(String user, String senha) throws NoSuchAlgorithmException{   	// Padrao Creat
		login = new Login();
		login.setLogin(user);
		login.criarSenha(senha);
	}


	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isDesativado() {
		return desativado;
	}

	public void setDesativado(boolean desativado) {
		this.desativado = desativado;
	}





}
