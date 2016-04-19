package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.ReservaDAO;
import com.br.model.Reserva;
import com.br.util.JPAUtil;

public class ReservaService {

	public  static void criar(Reserva reserva) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			
			if(reserva.getMesa() == null || reserva.getFuncionario() == null){
				throw new Exception("Reserva sem mesa ou funcionario responsavel");
			}
			
			reservaDAO.insert(reserva);
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
	
	public  static void atualizar(Reserva reserva) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			if(reserva.getMesa() == null || reserva.getFuncionario() == null){
				throw new Exception("Reserva sem mesa ou funcionario responsavel");
			}
			reservaDAO.update(reserva);
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
	
	public  static void remover(Reserva reserva) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			
			reservaDAO.delete(reserva);
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
	
	public  static Reserva procurar(Reserva reserva) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Reserva result = null;
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);			
			result = reservaDAO.findById(reserva.getId());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Reserva> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Reserva> result = Collections.emptyList();
		try{
			ReservaDAO reservaDAO = new ReservaDAO(manager);
			result = reservaDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
