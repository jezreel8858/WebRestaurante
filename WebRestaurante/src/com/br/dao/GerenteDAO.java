package com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Gerente;

public class GerenteDAO extends GenericDAO<Gerente> {
	
	public GerenteDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Gerente> getClassType() {
		return Gerente.class;
	}
	
	public boolean exist(Gerente gerente){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Gerente c WHERE c.login.login = :login");
		result.setParameter("login", gerente.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}
}
