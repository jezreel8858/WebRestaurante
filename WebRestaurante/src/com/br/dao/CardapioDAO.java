package com.br.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Cardapio;

public class CardapioDAO extends GenericDAO<Cardapio>{
	
	public CardapioDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Cardapio> getClassType() {
		return Cardapio.class;
	}
	
	public Object procurarPorNome(String nome){
		Query query = manager.createQuery("select c from Cardapio c where c.nome = :nome").setParameter("nome",nome);
		return query.getSingleResult();
	}
}
