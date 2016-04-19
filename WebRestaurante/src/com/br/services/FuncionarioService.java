package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.FuncionarioDAO;
import com.br.model.Funcionario;
import com.br.util.JPAUtil;

public class FuncionarioService {

	public  static void criar(Funcionario funcionario) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			boolean exist = funcionarioDAO.exist(funcionario);
			if(exist){
				throw new Exception("Funcionario já existe");
			}
				
			funcionarioDAO.insert(funcionario);
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
	
	public static void atualizar(Funcionario funcionario){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			funcionarioDAO.update(funcionario);
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
	
	public static void remover(Funcionario funcionario){
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			funcionarioDAO.delete(funcionario);
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
	
	public static void desativar(Funcionario funcionario) {
		funcionario.setDesativado(true);
		atualizar(funcionario);
	}
	
	public  static Funcionario procurar(Funcionario funcionario) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Funcionario result = null;
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			
			result = funcionarioDAO.findById(funcionario.getId());

			
		}catch (Exception e){

		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Funcionario> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Funcionario> result = Collections.emptyList();
		try{
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO(manager);
			result = funcionarioDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
