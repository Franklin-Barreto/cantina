package com.santander.cantina.modelo;

import java.math.BigDecimal;

public class RelatorioPorClienteValorTotalPedido {

	private String nome;
	private BigDecimal valor;

	public RelatorioPorClienteValorTotalPedido(String nome, BigDecimal valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
