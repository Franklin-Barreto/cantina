package com.santander.cantina.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao_produto")
public class AvaliacaoProduto {

	@EmbeddedId
	private AvaliacaoChave id;

	@ManyToOne
	@MapsId("clienteId")
	private Cliente cliente;

	@ManyToOne
	@MapsId("produtoId")
	private Produto produto;

	private int nota;
	private String detalhe;
	
	public AvaliacaoProduto(Cliente cliente, Produto produto, int nota, String detalhe) {
		this.id = new AvaliacaoChave(cliente.getId(), produto.getId());
		this.nota = nota;
		this.detalhe = detalhe;
	}
	
	protected AvaliacaoProduto() {}

	
	public AvaliacaoChave getId() {
		return id;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Integer getNota() {
		return nota;
	}
	
	public String getDetalhe() {
		return detalhe;
	}
	
	
	
	
}
