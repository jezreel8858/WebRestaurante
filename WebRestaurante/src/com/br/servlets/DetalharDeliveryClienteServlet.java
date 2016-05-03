package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.services.DeliveryService;


public class DetalharDeliveryClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String idPedido = request.getParameter("id");
		
		Delivery ped = new Delivery(Long.valueOf(idPedido));
		Delivery pedido = DeliveryService.procurar(ped);
		List<ItemCardapio> itensPed = pedido.getItensCardapio();
		List<ItemCardapio> itens = new ArrayList<>();
		
		for (ItemCardapio itemCardapio : itensPed) {
			if(itemCardapio.getPedido().getId()==pedido.getId()){
				itens.add(itemCardapio);
			}
		}
		
		request.getSession().setAttribute("itens",itens);
		request.getRequestDispatcher("detalhardeliverycliente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
