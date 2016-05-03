package com.br.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.model.Tradicional;
import com.br.model.Usuario;
import com.br.services.DeliveryService;
import com.br.services.TradicionalService;


public class AlterarPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		if(usuario instanceof Cliente){
			response.sendRedirect("LoginSistema");
			return;
		}
		String idPedido = request.getParameter("idPedido");
		String status =  request.getParameter("status"); 
		String tipo =  request.getParameter("tipo");
		
		if(!idPedido.equals("") && (status.equals("Cancelado") || status.equals("Atendido"))){
			
				if(tipo.equals("Delivery")){						
						Delivery delivery = new Delivery();
						delivery.setId(new Long(idPedido));
						delivery = DeliveryService.procurar(delivery);							
						if(delivery!=null){							
							delivery.setStatus(status);
							DeliveryService.atualizar(delivery);
							request.setAttribute("mensagem", "Pedido Alterado com Sucesso!");
							request.getRequestDispatcher("ListarPedidos").forward(request, response);
							return;
						}
				} else if(tipo.equals("Tradicional")) {
						Tradicional tradicional= new Tradicional(new Long(idPedido));
						tradicional = TradicionalService.procurar(tradicional);
						if(tradicional!=null){
							tradicional.setStatus(status);
							TradicionalService.atualizar(tradicional);
							request.setAttribute("mensagem", "Pedido Alterado com Sucesso!");
							request.getRequestDispatcher("ListarPedidos").forward(request, response);
							return;
						}
				}
		}
		request.removeAttribute("tipo");
		request.removeAttribute("idPedido");
		request.removeAttribute("status");
		request.setAttribute("mensagem", "Erro!");
		request.getRequestDispatcher("ListarPedidos").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
