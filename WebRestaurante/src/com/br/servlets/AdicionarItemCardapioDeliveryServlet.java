package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cardapio;
import com.br.model.ItemCardapio;
import com.br.services.CardapioService;


public class AdicionarItemCardapioDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("itemCardapio")==null){
			List<ItemCardapio> lista = new ArrayList<>();
			request.getSession().setAttribute("itemCardapio",lista);
		}
		ItemCardapio itemC = new ItemCardapio();
		String nome = request.getParameter("cardapio");
		String qtd = request.getParameter("quantidade");
		Cardapio cardapio = CardapioService.procurarPorNome(nome);
		
		itemC.setCardapio(cardapio);
		itemC.setQtd(Integer.valueOf(qtd));
		
		List<ItemCardapio> lista = (ArrayList<ItemCardapio>) request.getSession().getAttribute("itemCardapio");
		boolean existe = false;
		int idC = 0;
		for (ItemCardapio itemCardapio : lista) {
			if(itemC.getCardapio().getNome().equals(itemCardapio.getCardapio().getNome())){
				existe=true;
			}
			itemCardapio.setIdC(idC++);
		}
		if(!existe){
			lista.add(itemC);
		}
		
		
		request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
		
	}

}
