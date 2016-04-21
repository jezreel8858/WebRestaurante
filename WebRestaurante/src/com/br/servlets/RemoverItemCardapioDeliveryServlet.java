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
		ArrayList<ItemCardapio> lista = (ArrayList<ItemCardapio>) request.getSession().getAttribute("itemCardapio");
		
		String id = request.getParameter("id");
		int idC = Integer.valueOf(id);
		
		for (int x =0 ; x< lista.size() ; x++) {
			if(lista.get(x).getIdC()==idC){
				lista.remove(idC);
			}
		}
		for (int x =0 ; x< lista.size() ; x++) {
			lista.get(x).setIdC(x);
		}
		request.getSession().setAttribute("itemCardapio",lista);
		request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
