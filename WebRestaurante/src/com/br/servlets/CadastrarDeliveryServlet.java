package com.br.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cardapio;
import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.services.CardapioService;
import com.br.services.DeliveryService;


public class CadastrarDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<ItemCardapio> lista;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if(lista == null){
			lista = new ArrayList<>();
			request.getSession().setAttribute("itens", lista);
		}
		request.setAttribute("cardapios", CardapioService.listar());
		request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemCardapio itemC = new ItemCardapio();
		String id = request.getParameter("cardapio");
		String qtd = request.getParameter("quantidade");
		Cardapio cardapio = CardapioService.procurar(new Cardapio(new Long(id)));
		
		itemC.setCardapio(cardapio);
		itemC.setQtd(Integer.valueOf(qtd));
		
		boolean exist = false;
		for (ItemCardapio itemCardapio : lista) {
			if(itemCardapio.getCardapio().getNome().equals(cardapio.getNome())){
				itemCardapio.setQtd(itemCardapio.getQtd()+Integer.valueOf(qtd));
				exist = true;
			}
		}
		if(!exist)
			lista.add(itemC);
		doGet(request, response);
	}

}
