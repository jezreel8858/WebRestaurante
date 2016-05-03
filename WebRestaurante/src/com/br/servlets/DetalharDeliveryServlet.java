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
import com.br.model.Pedido;
import com.br.model.Tradicional;
import com.br.services.DeliveryService;
import com.br.services.TradicionalService;


public class DetalharDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String idPedido = request.getParameter("idPedido");
		String tipo = request.getParameter("tipo");
		Pedido pedido = null;
		
		if(tipo.equals("Delivery")){
			Delivery ped = new Delivery(Long.valueOf(idPedido));
			pedido = DeliveryService.procurar(ped);
		} else if (tipo.equals("Tradicional")){
			Tradicional ped = new Tradicional(Long.valueOf(idPedido));
			pedido = TradicionalService.procurar(ped);
		}
		
		List<ItemCardapio> itensPed = pedido.getItensCardapio();
		List<ItemCardapio> itens = new ArrayList<>();
		
		for (ItemCardapio itemCardapio : itensPed) {
			if(itemCardapio.getPedido().getId()==pedido.getId()){
				itens.add(itemCardapio);
			}
		}
		
		request.getSession().setAttribute("itens",itens);
		request.setAttribute("tipo", tipo);
		request.setAttribute("idPedido", idPedido);
		
		request.getRequestDispatcher("detalhardeliverycliente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
