package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.services.DeliveryService;


public class ListarMeusPedidosServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		} else {
			Cliente cliente = (Cliente) request.getSession().getAttribute("usuario");			
			
			List<Delivery> pedidos = DeliveryService.procurarPorClienteId(cliente.getId());			
			request.setAttribute("deliverys", pedidos);
		
			request.getRequestDispatcher("listardelivery.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		Cliente cliente = (Cliente) request.getSession().getAttribute("usuario");
		List<Delivery> pedidos = (List<Delivery>) cliente.getDeliverys();
		request.setAttribute("deliverys", pedidos);
	
		request.getRequestDispatcher("listardelivery.jsp").forward(request, response);
		
	}
}