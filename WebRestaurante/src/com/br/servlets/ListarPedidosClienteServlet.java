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

@WebServlet("/listarPedidosCliente")
public class ListarPedidosClienteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		String idNumero = request.getParameter("numero");

		Delivery delivery = new Delivery();	
		Cliente cliente = new Cliente();
		cliente.setId(new Long(id));
		
		delivery.setCliente(cliente);
		if(status != null && idNumero != null){
			delivery.setStatus(status.equals("Todos") ? "":status);
			try {
				delivery.setId(new Long(idNumero));
			} catch (Exception e) {
				// TODO: handle exception
			}
						
		}
		
		
		List<Delivery> pedidos = DeliveryService.buscarFiltro(delivery);
		request.setAttribute("cliente", id);
		request.setAttribute("deliverys", pedidos);
		request.getRequestDispatcher("listapedidoscliente.jsp").forward(request, response);
	}
}