package com.br.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Login;
import com.br.model.Usuario;
import com.br.services.UsuarioService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destroy();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("tLogin");  // era tLogin mestre e tSenha por isso ele nao logava direto
		String senha = request.getParameter("tSenha");
		
		Login login = new Login();
		login.setLogin(usuario);
		try {
			login.criarSenha(senha);
		} catch (NoSuchAlgorithmException e) {

		}
		
		
		Usuario cliente = UsuarioService.procurarPorLoginSenha(login);
		
		if(cliente!=null){				
			request.getSession().setAttribute("usuario", cliente);
			response.sendRedirect("cadastroDelivery");
			return;
		} 
		
		request.setAttribute("mensagem", "Usuario Invalido!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	

}
