package com.br.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.services.ClienteService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isUsuario = false;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		
//		Cliente cliente = ClienteService.procurarPorLoginSenha(login, senha);
//		Funcionario funcionario = FuncionarioService.procurarPorLoginSenha(login,senha);
//		Gerente gerente = GerenteService.procurarPorLoginSenha(login,senha);
		
		if(senha.length()==6){ // Tipo de Usuario Funcionario
		 
		} else if(senha.length()==8){ // Tipo de Usuario Gerente
			
		} else if(senha.length()>8){ // Tipo de Usuario Cliente
			Cliente cliente = ClienteService.procurarPorLoginSenha(login, senha);
		
			if(cliente!=null){				
				isUsuario = true;
				request.getSession().setAttribute("Usuario", cliente);
				request.getRequestDispatcher("cadastroDelivery").forward(request, response);
			} 
		}
		if(!isUsuario){
			request.getRequestDispatcher("index.jsp");
		}
	}
}
