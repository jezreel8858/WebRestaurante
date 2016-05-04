package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.services.ClienteService;

@WebServlet("/listarClientes")
public class ListarClientesServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		List<Cliente> clientes;
		String descricao = request.getParameter("fnome");
		
		if(descricao != null){
			Cliente filtro = new Cliente();
			filtro.setNome(descricao);
			clientes = ClienteService.buscarFiltro(filtro);
		}else{
			clientes = ClienteService.listar();
		}
		request.setAttribute("clientes", clientes);
		request.getRequestDispatcher("listarclientes.jsp").forward(request, response);
		
	}
}
