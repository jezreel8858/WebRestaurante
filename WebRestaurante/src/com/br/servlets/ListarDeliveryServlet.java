package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.services.DeliveryService;


public class ListarDeliveryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private List<Delivery> pedidos;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		if(pedidos == null || request.getSession().getAttribute("deliverys") == null){
			pedidos = new ArrayList<Delivery>();
		}
		Cliente usuario = (Cliente) request.getSession().getAttribute("usuario");
		String status = request.getParameter("status");
		String idNumero = request.getParameter("numero");
		if(status!=null && idNumero != null){
			if( !status.equals("Todos") ){
				pedidos = DeliveryService.procurarPorStatus(usuario.getId(), status);
				
			} else if ( status.equals("Todos")){
				pedidos = DeliveryService.procurarPorClienteId(usuario.getId());
			}
		}	
		 
		request.setAttribute("pedidos", pedidos);
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