package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.services.DeliveryService;

@WebServlet("/listarDelivery")
public class ListarDeliveryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		Cliente usuario = (Cliente) request.getSession().getAttribute("usuario");
		String status = request.getParameter("status");
		String idNumero = request.getParameter("numero");

		Delivery delivery = new Delivery();		
		delivery.setCliente(usuario);
		if(status != null && idNumero != null){
			delivery.setStatus(status.equals("Todos") ? "":status);
			try {
				delivery.setId(new Long(idNumero));
			} catch (Exception e) {
				// TODO: handle exception
			}
				
			
		}
		
		
		List<Delivery> pedidos = DeliveryService.buscarFiltro(delivery);
		 
		request.setAttribute("deliverys", pedidos);
		request.getRequestDispatcher("listardelivery.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
	
		request.getRequestDispatcher("listardelivery.jsp").forward(request, response);
		
	}
}