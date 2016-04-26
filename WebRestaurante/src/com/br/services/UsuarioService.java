package com.br.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.UsuarioDAO;
import com.br.model.Login;
import com.br.model.Usuario;
import com.br.util.JPAUtil;

public class UsuarioService {

		public  static void criar(Usuario usuario) {
			EntityManager  manager =  JPAUtil.getEntityManager();
			
			try{
				UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
				boolean exist = usuarioDAO.exist(usuario);
				if(exist){
					throw new Exception("Usuario já existe");
				}
					
				usuarioDAO.insert(usuario);
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
		
		public static void atualizar(Usuario usuario){
			EntityManager  manager =  JPAUtil.getEntityManager();
			
			try{
				UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
				usuarioDAO.update(usuario);
				manager.getTransaction().begin();
				manager.getTransaction().commit();
				
			}catch (Exception e){
				System.out.println(e.getMessage());
				if(manager.getTransaction().isActive())
					manager.getTransaction().rollback();
			}finally{
				
			}
		}
		
		public static void remover(Usuario usuario){
			EntityManager manager = JPAUtil.getEntityManager();
			
			try {
				UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
				usuarioDAO.delete(usuario);
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
		
		public static void desativar(Usuario usuario) {
			usuario.setDesativado(true);
			atualizar(usuario);
		}
		
		
		public  static Usuario procurar(Usuario usuario) {
			
			EntityManager  manager =  JPAUtil.getEntityManager();
			Usuario result = null;
			try{
				UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
				result = usuarioDAO.findById(usuario.getId());
				
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			finally{
				manager.close();
			}
			return result;
		}
		
		public  static Usuario procurarPorLoginSenha(Login login) {
			
			EntityManager  manager =  JPAUtil.getEntityManager();
			Usuario result = null;
			try{
				UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
				result = usuarioDAO.procurarLoginSenha(login);
				
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			finally{
				manager.close();
			}
			return result;
		}
		
		public static List<Usuario> listar(){
			EntityManager  manager =  JPAUtil.getEntityManager();
			List<Usuario> result = Collections.emptyList();
			try{
				UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
				result = usuarioDAO.getAll();
				
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			finally{
				manager.close();
			}
			return result;
		}
	

}
