package com.santander.cantina.modelo;

import java.math.BigDecimal;

public class TotalCompraMensalCliente {

	private String nome;
	private BigDecimal valorTotal;
	private String data;
	
	public TotalCompraMensalCliente(String nome, BigDecimal valorTotal, String data) {
		this.nome = nome;
		this.valorTotal = valorTotal;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getData() {
		return data;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	
	
}
