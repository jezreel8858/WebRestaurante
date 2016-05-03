package com.br.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cardapio;
import com.br.model.Cliente;
import com.br.model.Usuario;
import com.br.services.CardapioService;

//@WebServlet("/removerCardapio")
public class RemoverCardapioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		if(usuario instanceof Cliente){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String id = request.getParameter("id");
		CardapioService.remover(new Cardapio(new Long(id)));
		response.sendRedirect("listarCardapios");
	}
	
}
