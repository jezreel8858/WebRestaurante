package com.br.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Funcionario;
import com.br.model.Mesa;
import com.br.services.FuncionarioService;
import com.br.services.MesaService;

@WebServlet("/listarFuncionario")
public class ListarFuncionarioServlet extends HttpServlet{
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
		List<Funcionario> funcionarios;
		String descricao = request.getParameter("fNome");
		
		if(descricao != null){
			Funcionario filtro = new Funcionario();
			funcionarios = FuncionarioService.buscarFiltro(filtro);
		}else{
			funcionarios = FuncionarioService.listar();
		}
		request.setAttribute("funcionarios", funcionarios);
		request.getRequestDispatcher("listarfuncionario.jsp").forward(request, response);
		
	}
}
