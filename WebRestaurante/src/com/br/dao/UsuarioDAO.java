package com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.br.model.Login;
import com.br.model.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{

	public UsuarioDAO(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	public Class<Usuario> getClassType() {
		return Usuario.class;
	}
	
	public boolean exist(Usuario usuario){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Usuario c WHERE c.login.login = :login");
		result.setParameter("login", usuario.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}
	
	public Usuario procurarLoginSenha(Login login){
		try{
		Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login.login = :login and u.login.senha = :senha and u.desativado = :status ");
		query.setParameter("login",login.getLogin());
		query.setParameter("senha",login.getSenha());
		query.setParameter("status",false);
		
		return  (Usuario) query.getSingleResult();
		
	}catch (NoResultException nre){
		return null;
		}
	}
}
