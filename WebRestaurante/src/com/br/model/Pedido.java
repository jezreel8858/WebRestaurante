package com.br.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido implements EntityClass{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;	
	
	private String status;
	
	@ManyToOne
	@JoinColumn(name="fun_id")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy="pedido", fetch=FetchType.EAGER)   
	private List<ItemCardapio> itensCardapio = new ArrayList<>();
	
	public void addItemCardapio(int qtd, Cardapio cardapio){   // Padrao Creator
		ItemCardapio itemCardapio = new ItemCardapio();
		itemCardapio.setQtd(qtd);
		itemCardapio.setCardapio(cardapio);
		itemCardapio.setPedido(this);
		itensCardapio.add(itemCardapio);
	}
	public float getTotal(){		// Padrao Expert
		float totalResult = 0;
		for (ItemCardapio itemCardapio : itensCardapio) {
			totalResult += itemCardapio.getSubTotal();
		}
		return totalResult;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<ItemCardapio> getItemCardapios() {
		return itensCardapio;
	}
	public void setItemCardapios(List<ItemCardapio> itemCardapios) {
		this.itensCardapio = itemCardapios;
	}	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data=" + data + ", status=" + status + ", funcionario=" + funcionario
				+ ", "+ itensCardapio + "]";
	}

}


