package com.br.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Pedido;

public class PedidoDAO extends GenericDAO<Pedido>{

	public PedidoDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Pedido> getClassType() {
		return Pedido.class;
	}
	
	public List<Pedido> getPedidoStatus(String status){
		
		Query query = manager.createQuery("SELECT p FROM Pedido p WHERE p.status = :status");
		query.setParameter("status", status);
		
		@SuppressWarnings("unchecked")
		List<Pedido> resultList = query.getResultList();
		return resultList;
	}
	

}
