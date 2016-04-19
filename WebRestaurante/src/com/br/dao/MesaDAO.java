package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Mesa;

public class MesaDAO extends GenericDAO<Mesa>{

	public MesaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Mesa> getClassType() {
		return Mesa.class;
	}
}
