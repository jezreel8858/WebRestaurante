package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.services.DeliveryService;

@WebServlet("/detalharDeliveryCliente")
public class DetalharDeliveryClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String idPedido = request.getParameter("id");
		
		Delivery p = new Delivery(Long.valueOf(idPedido));
		Delivery pedido = DeliveryService.procurar(p);


		
		request.getSession().setAttribute("itens",pedido.getItensCardapio());
		request.getRequestDispatcher("detalhardeliverycliente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
