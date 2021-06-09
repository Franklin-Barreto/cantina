package com.santander.cantina.modelo;

import java.math.BigDecimal;

public class ProdutoMaisVendido {

	private String nome;
	private BigDecimal preco;
	
	public ProdutoMaisVendido(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	
}
