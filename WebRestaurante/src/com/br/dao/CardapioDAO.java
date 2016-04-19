package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Cardapio;

public class CardapioDAO extends GenericDAO<Cardapio>{
	
	public CardapioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Cardapio> getClassType() {
		return Cardapio.class;
	}
}
