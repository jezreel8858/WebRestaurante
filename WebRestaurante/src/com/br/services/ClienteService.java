package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.ClienteDAO;
import com.br.model.Cliente;
import com.br.util.JPAUtil;

public class ClienteService {

	public  static void criar(Cliente cliente) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			boolean exist = clienteDAO.exist(cliente);
			if(exist){
				throw new Exception("Usuario já existe");
			}
				
			clienteDAO.insert(cliente);
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
	
	public static void atualizar(Cliente cliente){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			clienteDAO.update(cliente);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}finally{
			
		}
	}
	
	public static void remover(Cliente cliente){
		EntityManager manager = JPAUtil.getEntityManager();
		
		try {
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			if(cliente.getDeliverys() == null){
				throw new Exception("Usuario possui deliveres registrado");
			}
			clienteDAO.delete(cliente);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(manager.getTransaction().isActive())
				manager.getTransaction().rollback();
		}finally{
			manager.close();
		}
	}
	
	public static void desativar(Cliente cliente) {
		cliente.setDesativado(true);
		atualizar(cliente);
	}
	
	
	public  static Cliente procurar(Cliente cliente) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Cliente result = null;
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			result = clienteDAO.findById(cliente.getId());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Cliente> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Cliente> result = Collections.emptyList();
		try{
			ClienteDAO clienteDAO = new ClienteDAO(manager);
			result = clienteDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
