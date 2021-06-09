package com.santander.cantina.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao = LocalDate.now();
	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;
	@OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Pedido() {
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void adicionaItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
	}

}
