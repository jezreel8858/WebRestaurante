package com.br.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.model.Cliente;
import com.br.model.Endereco;
import com.br.services.ClienteService;


public class AlterarContaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") == null){
			response.sendRedirect("LoginSistema");
			return;
		}	
		
		request.getRequestDispatcher("alterarcliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente usuario = (Cliente)request.getSession().getAttribute("usuario");
		
		String nome =  request.getParameter("tNome");
		String telefone = request.getParameter("tTelefone");
		String dataN = request.getParameter("tData");
		Date dataNascimento = null;		
		try {
			dataNascimento =  new SimpleDateFormat("yyyy-MM-dd").parse(dataN);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}		
		String email =  request.getParameter("tEmail");
		String rua = request.getParameter("tRua");
		String numero = request.getParameter("tNumero");
		String complemento = request.getParameter("tComplemento");
		String bairro = request.getParameter("tBairro"); 
		String cep = request.getParameter("tCep");
		String pais = request.getParameter("tPais");
		String estado = request.getParameter("tEst");
		String cidade = request.getParameter("tCidade");
		
		usuario.setNome(nome);
		usuario.setTelefone(telefone);
			
		usuario.setDataNasc(dataNascimento);
		usuario.setEmail(email);
		Endereco endereco = new Endereco();
		endereco.setLogradouro(rua);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setPais(pais);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		usuario.setEndereco(endereco);
		
		ClienteService.atualizar(usuario);
		request.setAttribute("mensagem", "Seus Dados Foram Alterados com Sucesso");
		doGet(request, response);
	}

}
