package com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Funcionario;

public class FuncionarioDAO extends GenericDAO<Funcionario>{

	public FuncionarioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Funcionario> getClassType() {
		return Funcionario.class;
	}
	
	public boolean exist(Funcionario funcionario){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Funcionario c WHERE c.login.login = :login");
		result.setParameter("login", funcionario.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}
}
