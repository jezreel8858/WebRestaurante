package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;

@WebServlet("/cadastroCategoria")
public class CadastrarCategoriaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		String id = request.getParameter("id");
		
		if(id != null){
			Categoria categoria = CategoriaService.procurar(new Categoria(new Long(id)));
			request.setAttribute("categoria", categoria);
		}
		request.getRequestDispatcher("cadastrocategoria.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		String id =  request.getParameter("id");
		String nome =  request.getParameter("nome");
		String status =  request.getParameter("status");
		
		Categoria categoria = new Categoria();
		
		categoria.setNome(nome);
		categoria.setStatus(status.equals("0") ? true: false);
		
		if(id != null && !id.equals("")){
			categoria.setId(new Long(id));
			CategoriaService.atualizar(categoria);
			request.setAttribute("mensagem", "Atualização efetuada com sucesso");
		}else{
			CategoriaService.criar(categoria);
			request.setAttribute("mensagem", "Cadastro efetuado com sucesso");
		}
		
		request.getRequestDispatcher("listarCategoria").forward(request, response);
		
	}
}
