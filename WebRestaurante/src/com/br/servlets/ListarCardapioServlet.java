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
import com.br.model.Cliente;
import com.br.model.Usuario;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;


@WebServlet("/listarCardapio")
public class ListarCardapioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		if(usuario instanceof Cliente){
			response.sendRedirect("LoginSistema");
			return;
		}
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}
		String filtroNome = request.getParameter("filtroNome");
		String filtroCategoria = request.getParameter("filtroCategoria");
		
		Cardapio filtro = new Cardapio();
		Categoria filtroCa = new Categoria();
		filtro.setNome(filtroNome);
		
		if(filtroCategoria != null && !filtroCategoria.equals("")){
			filtroCa.setId(new Long(filtroCategoria));
			
		}
		filtro.setCategoria(filtroCa);
		List<Categoria> categorias = CategoriaService.listar();
		List<Cardapio> cardapios = CardapioService.buscarFiltro(filtro);
		request.setAttribute("cardapios", cardapios);
		request.getSession().setAttribute("categorias", categorias);
		request.getRequestDispatcher("listarcardapio.jsp").forward(request, response);
	}

}
