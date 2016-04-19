package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Reserva;

public class ReservaDAO extends GenericDAO<Reserva>{

	public ReservaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Reserva> getClassType() {
		return Reserva.class;
	}
}
