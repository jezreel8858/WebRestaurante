package com.br.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.model.Funcionario;
import com.br.model.Login;
import com.br.model.Usuario;
import com.br.services.UsuarioService;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario")!=null){
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		}
		destroy();
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("tLogin");  
		String senha = request.getParameter("tSenha");
		
		Login login = new Login();
		login.setLogin(usuario);
		try {
			login.criarSenha(senha);
		} catch (NoSuchAlgorithmException e) {

		}
		
		
		Usuario usuarioLogado = UsuarioService.procurarPorLoginSenha(login);
		if(usuarioLogado!=null){	
			if(usuarioLogado instanceof Cliente){
				request.getSession().setAttribute("home", "cliente");
			} else if (usuarioLogado instanceof Funcionario){
				request.getSession().setAttribute("home", "funcionario");
			} else {
				request.getSession().setAttribute("home", "gerente");
			}
			request.getSession().setAttribute("usuario", usuarioLogado);			
			request.getRequestDispatcher("home.jsp").forward(request, response);
			return;
		} 
		
		request.setAttribute("mensagem", "Usuario Invalido!");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
