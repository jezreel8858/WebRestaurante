package com.br.model;

import java.security.NoSuchAlgorithmException;

import javax.persistence.Embeddable;

import com.br.util.HashPassword;

@Embeddable
public class Login {
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void criarSenha(String senha) throws NoSuchAlgorithmException{
		this.senha = HashPassword.convertHash(senha);
        
	}
	
}
