package com.santander.cantina.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "preco")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "produto_fk")
	private Produto produto;
	// refer�ncia bidirecional com pedido x item pedido
	@ManyToOne
	@JoinColumn(name = "pedido_fk")
	private Pedido pedido;
	private int quantidade;

	// anota��o que diz que um campo n�o ser� salvo no banco
	@Transient
	@Column(name = "valor_total")
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public ItemPedido(Produto produto, int quantidade) {
		this.valor = produto.getPreco();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorTotal = valor.multiply(BigDecimal.valueOf(quantidade));
	}

	public ItemPedido() {
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
