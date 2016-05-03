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

	@SuppressWarnings("unchecked")
	public List<Delivery> procurarPorClienteId(Long id) {
		Query result = null;
		result = manager.createQuery("SELECT d FROM Delivery d WHERE d.cliente.id = :id and d.desativado = :desativado").setParameter("id", id).setParameter("desativado", false);
		return (List<Delivery>) result.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Delivery> procurarPorStatus(Long id, String status) {
		Query result = null;
		result = manager.createQuery("SELECT d FROM Delivery d WHERE d.cliente.id = :id and d.status = :status and d.desativado = :desativado").setParameter("id", id).setParameter("status", status);
		return (List<Delivery>) result.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Delivery> procurarPorStatus(String status) {
		Query result = null;
		result = manager.createQuery("SELECT d FROM Delivery d WHERE d.status = :status ORDER BY d.id ASC").setParameter("status", status);
		return (List<Delivery>) result.getResultList();
	}
	
	public List<Delivery> buscarFiltro(Delivery filtro){
		String str = "select d from Delivery d where d.cliente.id = :id and d.desativado = :desativado";
		
		if(filtro.getId() != null){
			str+= " and d.id = :idDelivery";
		}
		if(filtro.getStatus() != null && !filtro.getStatus().equals("")){
			str+= " and d.status = :status";
		}
		
		Query query=manager.createQuery(str);  
		
		query.setParameter("id", filtro.getCliente().getId());
		query.setParameter("desativado", filtro.isDesativado());
		
		if(filtro.getStatus() != null && !filtro.getStatus().equals("")){
			query.setParameter("status", filtro.getStatus());
		}
		if(filtro.getId() != null){
			query.setParameter("idDelivery", filtro.getId());
		}
		return query.getResultList();
	}

	public void desativar(Long id) {
		Query result = manager.createQuery("SELECT d FROM Delivery d WHERE d.id = :id ").setParameter("id", id);
		Delivery delivery = (Delivery) result.getSingleResult();
		delivery.setDesativado(true);
		update(delivery);
		
	}

	public List<Delivery> buscarFiltroById(Delivery filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}
