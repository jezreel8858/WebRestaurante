package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.ItemCardapio;

public class ItemCardapioDAO extends GenericDAO<ItemCardapio>{
	
	public ItemCardapioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<ItemCardapio> getClassType() {
		return ItemCardapio.class;
	}

}
