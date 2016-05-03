package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Mesa;
import com.br.services.MesaService;

@WebServlet("/listarMesa")
public class ListarMesaServlet extends HttpServlet{
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
		List<Mesa> mesas;
		String descricao = request.getParameter("nome");
		String opcao = request.getParameter("opcao");
		
		if(descricao != null){
			Mesa filtro = new Mesa();
			filtro.setDescricao(descricao);
			if(opcao.equals("0")){
				filtro.setPerReserva(true);
			}
			if(opcao.equals("1")){
				filtro.setPerReserva(false);
			}
			mesas = MesaService.buscarFiltro(filtro);
		}else{
			mesas = MesaService.listar();
		}
		request.setAttribute("mesas", mesas);
		request.getRequestDispatcher("listarmesa.jsp").forward(request, response);
		
	}
}
