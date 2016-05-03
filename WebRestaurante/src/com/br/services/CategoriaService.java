package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.CategoriaDAO;
import com.br.model.Categoria;
import com.br.model.Cliente;
import com.br.util.JPAUtil;

public class CategoriaService {

	public  static void criar(Categoria categoria) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			
			categoriaDAO.insert(categoria);
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
	
	public  static void remover(Categoria categoria) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			
			categoriaDAO.delete(categoria);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	}
	
	public static void desativar(Categoria cat) {
		Categoria categoria = procurar(cat);
		categoria.setStatus(!categoria.isStatus());
		atualizar(categoria);
	}
	
	public  static Categoria procurar(Categoria categoria) {
		
		EntityManager  manager =  JPAUtil.getEntityManager();
		Categoria result = null;
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			result = categoriaDAO.findById(categoria.getId());
			
		}catch (Exception e){

		}
		finally{
			manager.close();
		}
		return result;
	}

	public static List<Categoria> listar(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Categoria> result = Collections.emptyList();
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			result = categoriaDAO.getAll();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static List<Categoria> listarAtivo(){
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Categoria> result = Collections.emptyList();
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			result = categoriaDAO.getCategoriaAtivo();
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
	
	public static void atualizar(Categoria categoria) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			
			categoriaDAO.update(categoria);
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

	public static List<Categoria> buscarFiltro(Categoria filtro) {
		EntityManager  manager =  JPAUtil.getEntityManager();
		List<Categoria> result = Collections.emptyList();
		try{
			CategoriaDAO categoriaDAO = new CategoriaDAO(manager);
			result = categoriaDAO.getByName(filtro);
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally{
			manager.close();
		}
		return result;
	}
}
