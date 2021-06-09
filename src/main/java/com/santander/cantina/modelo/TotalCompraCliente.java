package com.santander.cantina.modelo;

import java.math.BigDecimal;

public class TotalCompraCliente {

	private String nome;
	private BigDecimal total;
	private String cpf;
	
	public TotalCompraCliente(String nome, BigDecimal total,String cpf) {
		this.nome = nome;
		this.total = total;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public String getCpf() {
		return cpf;
	}
	
	
}
