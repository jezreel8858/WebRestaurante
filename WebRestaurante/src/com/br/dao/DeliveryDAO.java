package com.br.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Delivery;

public class DeliveryDAO extends GenericDAO<Delivery>{

	public DeliveryDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Delivery> getClassType() {
		return Delivery.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getRelatorioPorData(Date dataI, Date dataF){
		Query result = null;
		List<Object[]> lista = null;
		result = manager.createQuery("SELECT d.cliente.nome,d.data,SUM(i.qtd * i.cardapio.preco) FROM Delivery d inner join d.itensCardapio i"
									+ " where d.status = 'Atendido' and d.data between :dataI and :dataF  group by d.cliente.nome,d.data");
		result.setParameter("dataI", dataI);
		result.setParameter("dataF", dataF);
		lista =  result.getResultList();
		return lista;
	}
}
