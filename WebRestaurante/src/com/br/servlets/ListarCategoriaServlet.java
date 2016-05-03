package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Categoria;
import com.br.model.Mesa;
import com.br.services.CategoriaService;
import com.br.services.MesaService;

@WebServlet("/listarCategoria")
public class ListarCategoriaServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		List<Categoria> mesas;
		String nome = request.getParameter("fnome");
		
		if(nome != null){
			Categoria filtro = new Categoria();
			filtro.setNome(nome);

			mesas = CategoriaService.buscarFiltro(filtro);
		}else{
			mesas = CategoriaService.listar();
		}
		request.setAttribute("categorias", mesas);
		request.getRequestDispatcher("listarcategoria.jsp").forward(request, response);
		
	}
}
