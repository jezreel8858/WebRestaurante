package com.br.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Categoria;
import com.br.services.CategoriaService;

@WebServlet("/desativarCategoria")
public class DesativarCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String id = request.getParameter("id");
		CategoriaService.desativar(new Categoria(new Long(id)));
		response.sendRedirect("listarCategoria");
	}	
}
