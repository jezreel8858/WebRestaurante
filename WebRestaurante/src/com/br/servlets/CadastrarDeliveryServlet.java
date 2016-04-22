package com.br.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Delivery;
import com.br.services.DeliveryService;


public class CadastrarDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null){
			Delivery delivery = DeliveryService.procurar(new Delivery(new Long(id)));
			request.setAttribute("delivery", delivery);
		}
		
		request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
	}

}
