package com.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="ItemCardapio")
public class ItemCardapio implements EntityClass{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int qtd;
	
	@ManyToOne
	private Pedido pedido;
	
	@ManyToOne
	private Cardapio cardapio;
	
	public float getSubTotal(){			// Padrao Expert
		return cardapio.getPreco()*qtd;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cardapio getCardapio() {
		return cardapio;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	@Override
	public String toString() {
		return "ItemCardapio [id=" + id + ", qtd=" + qtd + ", "+ cardapio +"]";
	}
	
}
