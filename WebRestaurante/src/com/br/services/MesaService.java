package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.MesaDAO;
import com.br.model.Mesa;
import com.br.util.JPAUtil;

public class MesaService {

	public  static void criar(Mesa mesa) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			mesaDAO.insert(mesa);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void atualizar(Mesa mesa) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			mesaDAO.update(mesa);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static void remover(Mesa mesa) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			mesaDAO.delete(mesa);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public  static Mesa procurar(Mesa mesa) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Mesa result = null;
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			
			result = mesaDAO.findById(mesa.getId());
			
		}catch (Exception e){

		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Mesa> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Mesa> result = Collections.emptyList();
		try{
			MesaDAO mesaDAO = new MesaDAO(manager);
			result = mesaDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
