package com.br.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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

@WebServlet("/cadastroDelivery")
public class CadastrarDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		String pagamento = request.getParameter("pagamento");
		Cliente cliente = (Cliente)request.getSession().getAttribute("usuario");
		
		if(pagamento != null && !pagamento.isEmpty() && !getItensSession(request).isEmpty()){
			Delivery delivery = new Delivery();
			delivery.setItensCardapio(getItensSession(request));

			try {
				float pag = Float.parseFloat(pagamento);
				
				if(delivery.getTotal() < pag){
					delivery.setTroco(pag - delivery.getTotal());
					delivery.setData(new Date());
					delivery.setCliente(cliente);
									
					delivery.setStatus("Pendente");
					delivery.setDesativado(false);
					
					DeliveryService.criar(delivery);
					request.getSession().removeAttribute("itens");
					request.setAttribute("mensagem", "Pedido efetuado com Sucesso!");
					request.getRequestDispatcher("listarDelivery").forward(request, response);
					return;
				}else{
					request.setAttribute("erro", "Adicione o preço do pagamento");
				}
			} catch (Exception e) {

			}
			
		} 
			
		request.setAttribute("cardapios", CardapioService.listarAtivo());
		request.getRequestDispatcher("cadastrodelivery.jsp").forward(request, response);
		
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
		for (ItemCardapio itemCardapio : getItensSession(request)) {
			if(itemCardapio.getCardapio().getNome().equals(cardapio.getNome())){
				itemCardapio.setQtd(itemCardapio.getQtd()+Integer.valueOf(qtd));
				exist = true;
			}
		}
		if(!exist)
			addItem(request, itemC);
		
		doGet(request, response);
	}
	
	private void addItem(HttpServletRequest request, ItemCardapio item){
		List<ItemCardapio> lista = getItensSession(request);
		lista.add(item);
		setItensSession(request, lista);
	}
	
	private List<ItemCardapio> getItensSession(HttpServletRequest request){
		List<ItemCardapio> lista = (List<ItemCardapio>) request.getSession().getAttribute("itens");
		if(lista == null){
			lista = new ArrayList<>();
		}
		return lista;
	}
	
	private void setItensSession(HttpServletRequest request, List lista){
		request.getSession().setAttribute("itens", lista);
	}
}
