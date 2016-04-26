package com.br.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Login;
import com.br.model.Usuario;
import com.br.services.UsuarioService;

//@WebServlet("/LoginSistema")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Login novoLogin = new Login();
		novoLogin.setLogin(usuario);
		try {
			novoLogin.criarSenha(senha);
		} catch (NoSuchAlgorithmException e) {

		}
		
		
		Usuario cliente = UsuarioService.procurarPorLoginSenha(novoLogin);
		
		if(cliente!=null){				
			request.getSession().setAttribute("usuario", cliente);
			response.sendRedirect("cadastroDelivery");
			return;
		} 
		request.setAttribute("mensagem", "Usuario Invalido!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
