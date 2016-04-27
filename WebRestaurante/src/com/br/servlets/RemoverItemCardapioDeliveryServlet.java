package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.ItemCardapio;

public class RemoverItemCardapioDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		ArrayList<ItemCardapio> lista = (ArrayList<ItemCardapio>) request.getSession().getAttribute("itens");
		
		String id = request.getParameter("id");
		int idC = Integer.valueOf(id);
		for (int x =0 ; x< lista.size() ; x++) {
			if(lista.get(x).getCardapio().getId()==idC){
				lista.remove(x);
			}
		}

		response.sendRedirect("cadastroDelivery");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
	}

}
