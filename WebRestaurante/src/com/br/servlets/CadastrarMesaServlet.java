package com.br.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Mesa;
import com.br.services.MesaService;

public class CadastrarMesaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null){
			Mesa mesa = MesaService.procurar(new Mesa(new Long(id)));
			request.setAttribute("mesa", mesa);
		}
		
		request.getRequestDispatcher("cadastromesa.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =  request.getParameter("id");
		
		String nome =  request.getParameter("numero");
		String descricao =  request.getParameter("descricao");
		String preco =  request.getParameter("capacidade");
		String reserva =  request.getParameter("reserva");
		
		Mesa mesa = new Mesa();
		mesa.setNumero(Integer.parseInt(nome));
		mesa.setCapacidade(Integer.parseInt(preco));
		mesa.setDescricao(descricao);
		
		mesa.setPerReserva(Integer.parseInt(reserva) == 0 ? true : false);
		if(id != null && !id.equals("")){
			mesa.setId(new Long(id));
			MesaService.atualizar(mesa);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		}else{
			MesaService.criar(mesa);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}
		
		request.getRequestDispatcher("listarMesa").forward(request, response);
		
	}
}
