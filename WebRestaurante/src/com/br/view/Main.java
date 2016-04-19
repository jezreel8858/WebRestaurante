package com.br.view;

import java.text.ParseException;

import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.Mesa;
import com.br.model.Tradicional;
import com.br.services.CardapioService;
import com.br.services.CategoriaService;
import com.br.services.MesaService;
import com.br.services.TradicionalService;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		// Teste Pedido Tradicional
//		Mesa mesa = new Mesa();
//		mesa.setNumero(5);
//		MesaService.criar(mesa);
//		Categoria categoria = new Categoria();
//		categoria.setNome("Bebida");
//		CategoriaService.criar(categoria);
//		
//		Cardapio cardapio = new Cardapio();
//		cardapio.setNome("Coca");
//		cardapio.setPreco(3.5f);
//		cardapio.setCategoria(categoria);		
//		CardapioService.criar(cardapio);
//		
//		Tradicional pedido = new Tradicional();
//		pedido.addItemCardapio(10, cardapio);
//		pedido.setMesa(mesa);	
//		
//		TradicionalService.criar(pedido);
		
		// Teste Reserva
//		
//		Reserva reserva = new Reserva();
//		Funcionario funcionario =  new Funcionario();
//		funcionario.setNome("Ralph Carneiro");
//		reserva.setFuncionario(funcionario);
//		Mesa mesa = new Mesa();
//		mesa.setNumero(7);
//		MesaService.criar(mesa);
//		reserva.setMesa(mesa);
//		reserva.setNomeResp("Alisson Alex");
//		reserva.setnPessoas(2);
//		
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//		Date dataI = (Date)formatter.parse("01/01/2016");
//		Date dataF = (Date)formatter.parse("02/02/2016");
//		reserva.setDataInicio(dataI);
//		reserva.setDataFim(dataF);
//		ReservaService.criar(reserva);		
		
		// Teste de Login
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Alex");
//		try {
//			cliente.createLogin("Ralph", "123");
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}		
//		cliente.setDataCadastro(new Date());
//	
//		ClienteService.criar(cliente);
		
		// Teste Delivery
//		Cliente cliente = new Cliente();
//		Delivery delivery =  new Delivery();
//		Cardapio cardapio = new Cardapio();
//		Categoria categoria = new Categoria();
//		categoria.setNome("Bebida");
//		CategoriaService.criar(categoria);
//		
//		cardapio.setNome("Coca");
//		cardapio.setPreco(3.5f);	
//
//		cardapio.setCategoria(categoria);		
//		CardapioService.criar(cardapio);
//		
//		Funcionario funcionario =  new Funcionario();
//		funcionario.setNome("Ralph Carneiro");
//		
//		cliente.setId(6L);
//		cliente = ClienteService.procurar(cliente);
//		
//		delivery.setCliente(cliente);
//		delivery.addItemCardapio(1, cardapio);
//		delivery.setData(new Date());
//		delivery.setFuncionario(funcionario);
//		DeliveryService.criar(delivery);
	
		// Teste Relatorio Pedidos
//		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
//		Date dataI = (Date)formatter.parse("01/01/2016");
//		Date dataF = (Date)formatter.parse("01/02/2016");
//		List<Object[]> listaTradicional = TradicionalService.relatorioPorIntervaloData(dataI, dataF);
//		List<Object[]> listaDelivery = DeliveryService.relatorioPorIntervaloData(dataI, dataF);
//		
//		
//		for (Object[] object : listaTradicional) {
//			for (Object object2 : object) {
//				System.out.println(object2);
//			}
//		}
//		for (Object[] object : listaDelivery) {
//			for (Object object2 : object) {
//				System.out.println(object2);
//			}
//		}
 
	}

}
