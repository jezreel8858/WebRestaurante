package com.br.dao;

import java.util.List;

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

	public List<Cardapio> buscar(Cardapio filtro){
		String str = "select c from Cardapio c where upper(nome) like upper(:nome)";
		if(filtro.getNome() == null){
			filtro.setNome("");
		}
		if(filtro.getCategoria().getId() != null && filtro.getPreco() >= 0){
			str+=" and c.categoria.id = :categoria";
		}
		Query query=manager.createQuery(str);   
		
		query.setParameter("nome", "%"+filtro.getNome()+"%");
		
		if(filtro.getCategoria().getId() != null && filtro.getPreco() >= 0){
			query.setParameter("categoria", filtro.getCategoria().getId());
		}
		return query.getResultList();
	}

}
