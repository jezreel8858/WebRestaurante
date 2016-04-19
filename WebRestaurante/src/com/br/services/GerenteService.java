package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.GerenteDAO;
import com.br.model.Gerente;
import com.br.util.JPAUtil;

public class GerenteService {

	public  static void criar(Gerente gerente) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);
			boolean exist = gerenteDAO.exist(gerente);
			if(exist){
				throw new Exception("Usuario já existe");
			}
				
			gerenteDAO.insert(gerente);
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
	
	public static void atualizar(Gerente gerente){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);
			gerenteDAO.update(gerente);
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
	
	public static void remover(Gerente gerente){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);
			gerenteDAO.delete(gerente);
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
	
	public static void desativar(Gerente gerente) {
		gerente.setDesativado(true);
		atualizar(gerente);
	}
	
	public  static Gerente find(Gerente gerente) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Gerente result = null;
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);			
			result = gerenteDAO.findById(gerente.getId());	
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Gerente> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Gerente> result = Collections.emptyList();
		try{
			GerenteDAO gerenteDAO = new GerenteDAO(manager);
			result = gerenteDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
