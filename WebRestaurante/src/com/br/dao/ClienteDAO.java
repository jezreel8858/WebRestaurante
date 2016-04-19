package com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Cliente;

public class ClienteDAO extends GenericDAO<Cliente>{

	public ClienteDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Cliente> getClassType() {
		return Cliente.class;
	}
	
	public boolean exist(Cliente cliente){
		Query result = null;
		result = this.manager.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.login.login = :login");
		result.setParameter("login", cliente.getLogin().getLogin());
		
		return ((long) result.getSingleResult()) != 0;
	}
	

}
