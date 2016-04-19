package com.br.services;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.DeliveryDAO;
import com.br.dao.ItemCardapioDAO;
import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.util.JPAUtil;

public class DeliveryService {

	public  static void criar(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			if(delivery.getCliente() == null ){
				throw new Exception("Delivery sem cliente");
			}
			for(ItemCardapio itemCardapio:delivery.getItemCardapios()){
				if(itemCardapio.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				ItemCardapioDAO.insert(itemCardapio);
			}
			deliveryDAO.insert(delivery);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void atualizar(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio itemCardapio:delivery.getItemCardapios()){
				if(itemCardapio.getCardapio() == null ){
					throw new Exception("Item sem cardápio");
				}
				ItemCardapioDAO.update(itemCardapio);
			}
			deliveryDAO.update(delivery);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void remover(Delivery delivery) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			ItemCardapioDAO ItemCardapioDAO = new ItemCardapioDAO(manager);
			
			for(ItemCardapio ItemCardapio:delivery.getItemCardapios()){
				ItemCardapioDAO.delete(ItemCardapio);
			}
			
			deliveryDAO.delete(delivery);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static Delivery procurar(Delivery delivery) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Delivery result = null;
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);	
			result = deliveryDAO.findById(delivery.getId());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Delivery> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Delivery> result = Collections.emptyList();
		try{
			DeliveryDAO deliveryDAO = new DeliveryDAO(manager);
			result = deliveryDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Object[]> relatorioPorIntervaloData(Date dataI,Date dataF){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Object[]> lista = null;
		try{
			DeliveryDAO pedidoDAO = new DeliveryDAO(manager);
			lista = pedidoDAO.getRelatorioPorData(dataI, dataF);			
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return lista;
	}

}
