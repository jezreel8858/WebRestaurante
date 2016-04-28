package com.br.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.Tradicional;

public class TradicionalDAO extends GenericDAO<Tradicional> {

	public TradicionalDAO(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Tradicional> getClassType() {
		return Tradicional.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getRelatorioPorData(Date dataI, Date dataF){
		Query result = null;
		List<Object[]> lista = null;
		result = manager.createQuery("SELECT t.data,SUM(i.qtd * i.cardapio.preco) FROM Tradicional t inner join t.itensCardapio i"
				+ " where t.status = 'Atendido' and t.data between :dataI and :dataF  group by t.data");
		result.setParameter("dataI", dataI);
		result.setParameter("dataF", dataF);
		lista =  result.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Tradicional> procurarPorStatus(String status) {
		Query result = null;
		result = manager.createQuery("SELECT t FROM Tradicional t WHERE t.status = :status").setParameter("status", status);
		return (List<Tradicional>) result.getResultList();
	};
	
}
