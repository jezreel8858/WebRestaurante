package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria>{
	
	public CategoriaDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Categoria> getClassType() {
		return Categoria.class;
	}

}
