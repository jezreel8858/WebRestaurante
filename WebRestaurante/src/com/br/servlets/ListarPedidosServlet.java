package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Delivery;
import com.br.model.Pedido;
import com.br.model.Tradicional;
import com.br.services.DeliveryService;
import com.br.services.TradicionalService;


public class ListarPedidosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Delivery> pedidosD;
	private List<Tradicional> pedidosT;
	private List<Pedido> pedidos;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		if(pedidosD == null || pedidosT == null || pedidos == null || request.getSession().getAttribute("pedidos") == null || request.getSession().getAttribute("deliverys") == null || request.getSession().getAttribute("tradicionais") == null){
			pedidosD = new ArrayList<>();
			pedidosT = new ArrayList<>();
			pedidos = new ArrayList<>();
		}
		
		String status = request.getParameter("status");
		String idNumero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		
		request.setAttribute("tipo", tipo);
		request.setAttribute("status", status);
		
		if(status!=null && idNumero != null && tipo != null){
			if(tipo.equals("Todos")){
				pedidos = new ArrayList<>();
				pedidosD = DeliveryService.listar();
				pedidosT = TradicionalService.listar();
				for (Delivery pedido : pedidosD) {
					pedidos.add(pedido);
				}
				for (Tradicional pedido : pedidosT) {
					pedidos.add(pedido);
				} 
				pedidos.sort(new Comparator<Pedido>() {
					@Override
					public int compare(Pedido ped1, Pedido ped2) {
						// TODO Auto-generated method stub
						return ped1.getId().compareTo(ped2.getId());
					}
					
				});
				request.setAttribute("pedidos", pedidos);
			} else if (tipo.equals("Delivery")){
				if( status.equals("Todos") ){
					pedidosD = DeliveryService.listar();
				} else {
					pedidosD = DeliveryService.procurarPorStatus(status);
				}
				request.setAttribute("pedidos", pedidosD);
			} else {
				if( status.equals("Todos") ){
					pedidosT = TradicionalService.listar();
				} else {
					pedidosT = TradicionalService.procurarPorStatus(status);
				}
				request.setAttribute("pedidos", pedidosT);
			}
				
		}			
		request.getRequestDispatcher("listarpedidos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
	
		request.getRequestDispatcher("listarpedidos.jsp").forward(request, response);
	}

}
