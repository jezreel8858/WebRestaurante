package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.Usuario;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;

//@WebServlet("/cadastroCardapio")
public class CadastrarCardapioServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}

		String id = request.getParameter("id");
		
		if(id != null){
			Cardapio cardapio = CardapioService.procurar(new Cardapio(new Long(id)));
			request.setAttribute("cardapio", cardapio);
		}
		List<Categoria> categorias = CategoriaService.listar();
		request.setAttribute("categorias", categorias);
		request.getRequestDispatcher("cadastrocardapio.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		String id =  request.getParameter("id");
		String nome =  request.getParameter("nome");
		String preco =  request.getParameter("preco");
		
		Cardapio cardapio = new Cardapio();
		
		cardapio.setNome(nome);
		cardapio.setPreco(new Float(preco));
		
		if(id != null && !id.equals("")){
			cardapio.setId(new Long(id));
			CardapioService.atualizar(cardapio);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		}else{
			CardapioService.criar(cardapio);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}
		
		request.getRequestDispatcher("listarCardapios").forward(request, response);
		
	}
}
