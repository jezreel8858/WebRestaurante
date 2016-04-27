package com.br.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cardapio;
import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.model.ItemCardapio;
import com.br.services.CardapioService;
import com.br.services.DeliveryService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class CadastrarDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<ItemCardapio> lista;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		if(lista == null){
			lista = new ArrayList<>();
		}
		request.getSession().setAttribute("itens", lista);
		request.setAttribute("cardapios", CardapioService.listar());
		
		String pagamento = request.getParameter("pagamento");
		Cliente cliente = (Cliente)request.getSession().getAttribute("usuario");
		
		if(pagamento != null && cliente != null){
			Delivery delivery = new Delivery();

			Date dataPedido = null;
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				try {
					dataPedido = (Date) format.parse(format.format(new Date()));
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			delivery.setData(dataPedido);
			delivery.setCliente(cliente);
			delivery.setItemCardapios(lista);			
			
			
			delivery.setStatus("Pendente");
			DeliveryService.criar(delivery);
			
			
			request.getRequestDispatcher("listarDelivery").forward(request, response);
		} else {
			request.getSession().setAttribute("itens", lista);
			request.setAttribute("cardapios", CardapioService.listar());
			request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
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
